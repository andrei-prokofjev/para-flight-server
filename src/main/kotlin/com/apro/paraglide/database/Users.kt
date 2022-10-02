package com.apro.paraglide.database

import org.jetbrains.exposed.sql.Table


object Users : Table() {
    val id = integer("id").autoIncrement()
    override val primaryKey = PrimaryKey(id)
    val name = varchar("name", 255)
    var registerDate = long("registerDate")
}

data class User(val id: Int, val name: String, val registerDate: Long)