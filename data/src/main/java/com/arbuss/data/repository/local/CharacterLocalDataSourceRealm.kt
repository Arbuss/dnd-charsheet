package com.arbuss.data.repository.local

import com.arbuss.data.model.Character
import com.arbuss.data.model.character.CharacterExperience
import com.arbuss.data.model.character.CharacterLevel
import com.arbuss.data.model.character.CharacterTitleInfo
import com.arbuss.data.repository.local.model.CharacterRealm
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.max
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

internal class CharacterLocalDataSourceRealm : CharacterLocalDataSource {
    private val config = RealmConfiguration.create(schema = setOf(CharacterRealm::class))
    private val realm: Realm = Realm.open(config)

    override fun getAllCharacters(): List<Character> {
        return realm.query<CharacterRealm>().find().toList().map { it.toAppModel() }
    }

    override fun getAllCharactersFromCampaignObservable(campaignId: Int): Flow<List<Character>> {
        return realm.query<CharacterRealm>("campaignId = $campaignId").find().asFlow()
            .flowOn(Dispatchers.IO)
            .map { realmResult -> realmResult.list.map { it.toAppModel() } }
    }

    override fun getCharacter(id: Int): Character? {
        return realm.query<CharacterRealm>().find().find { it.id == id }?.toAppModel()
    }

    override fun addCharacter(character: Character) {
        if (character.id == null) {
            val id = generateId()
            realm.writeBlocking {
                copyToRealm(character.toRealmModel(id = id))
            }
        } else {
            updateCharacter(character)
        }
    }

    override fun updateCharacter(character: Character) {
        realm.writeBlocking {
            val oldCharacter = query<CharacterRealm>().query("id = ${character.id}").first().find()
            if (oldCharacter == null) {
                copyToRealm(character.toRealmModel(generateId()))
            } else {
                oldCharacter.name = character.name
            }
        }
    }

    override fun deleteCharacter(character: Character) {
        character.id?.let {
            deleteCharacter(it)
        }
    }

    override fun deleteCharacter(id: Int) {
        realm.writeBlocking {
            val characterToDelete = query<CharacterRealm>("id = $id").find().first()
            delete(characterToDelete)
        }
    }

    override fun getAllCharactersFromCampaign(campaignId: Int): List<Character> {
        return realm.query<CharacterRealm>("campaignId = $campaignId").find().toList()
            .map { it.toAppModel() }
    }


    private fun generateId(): Int =
        realm.query<CharacterRealm>().max<Int>("id").find()?.plus(1) ?: 0

    private fun CharacterRealm.toAppModel(): Character =
        Character(
            id,
            name,
            CharacterTitleInfo(
                race,
                characterClass,
                armorPoint,
                speed,
                initiative,
                CharacterExperience(experience, CharacterLevel.fromLevel(level))
            ),
            campaignId,
        )

    private fun Character.toRealmModel(id: Int): CharacterRealm = CharacterRealm().apply {
        this.id = id
        this.name = this@toRealmModel.name
        this.campaignId = this@toRealmModel.campaignId
        race = this@toRealmModel.titleInfo.race
        characterClass = this@toRealmModel.titleInfo.characterClass
        armorPoint = this@toRealmModel.titleInfo.armorPoint
        speed = this@toRealmModel.titleInfo.speed
        initiative = this@toRealmModel.titleInfo.initiative
        experience = this@toRealmModel.titleInfo.experience.value
        level = this@toRealmModel.titleInfo.experience.level.levelAsInt
    }
}