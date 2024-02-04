package com.arbuss.data.repository.local.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

internal class CharacterRealm : RealmObject {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""
    var campaignId: Int = -1
}
