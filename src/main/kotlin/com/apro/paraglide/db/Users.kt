package com.apro.paraglide.db

import org.jetbrains.exposed.sql.Table


object Users : Table() {
    private val id = integer("id").autoIncrement()
    override val primaryKey = PrimaryKey(id)
    val name = varchar("name", 255)
    var registerDate = long("registerDate")
}

data class User(val name: String, val registerDate: Long)