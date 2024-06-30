package com.arbuss.data.repository.local

import com.arbuss.data.model.Campaign
import com.arbuss.data.repository.local.model.СampaignRealm
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.max
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

internal class CampaignLocalDataSourceRealm : CampaignLocalDataSource {
    private val config = RealmConfiguration.create(schema = setOf(СampaignRealm::class))
    private val realm: Realm = Realm.open(config)

    override fun getAllCampaign(): List<Campaign> {
        return realm.query<СampaignRealm>().find().toList().map { it.toAppModel() }
    }

    override fun getAllCampaignObservable(): Flow<List<Campaign>> {
        return realm.query<СampaignRealm>().find().asFlow().flowOn(Dispatchers.IO)
            .map { realmResult -> realmResult.list.map { it.toAppModel() } }
    }

    override fun getCampaign(id: Int): Campaign? {
        return realm.query<СampaignRealm>().find().find { it.id == id }?.toAppModel()
    }

    override fun addCampaign(campaign: Campaign) {
        if (campaign.id == null) {
            val id = generateId()
            realm.writeBlocking {
                copyToRealm(campaign.toRealmModel(id = id))
            }
        } else {
            updateCampaign(campaign)
        }
    }

    override fun updateCampaign(campaign: Campaign) {
        realm.writeBlocking {
            val oldcampaign = query<СampaignRealm>().query("id = ${campaign.id}").first().find()
            if (oldcampaign == null) {
                copyToRealm(campaign.toRealmModel(generateId()))
            } else {
                oldcampaign.name = campaign.name
            }
        }
    }

    override fun deleteCampaign(campaign: Campaign) {
        campaign.id?.let {
            deleteCampaign(it)
        }
    }

    override fun deleteCampaign(id: Int) {
        realm.writeBlocking {
            val campaignToDelete = query<СampaignRealm>("id = $id").find().first()
            delete(campaignToDelete)
        }
    }


    private fun generateId(): Int = realm.query<СampaignRealm>().max<Int>("id").find()?.plus(1) ?: 0

    private fun СampaignRealm.toAppModel(): Campaign = Campaign(this.id, this.name)
    private fun Campaign.toRealmModel(id: Int): СampaignRealm = СampaignRealm().apply {
        this.id = id
        this.name = this@toRealmModel.name
    }
}