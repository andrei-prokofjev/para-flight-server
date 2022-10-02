package com.apro.paraglide.database

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class UserService {

    suspend fun getAllUsers(): List<User> = newSuspendedTransaction {
        Users.selectAll().map { toUsers(it) }
    }

    fun insertUser(userName: String) {
        transaction {
            Users.insert {
                it[name] = userName
                it[registerDate] = System.currentTimeMillis()
            }
        }
    }

    private fun toUsers(row: ResultRow): User {
        return User(
            id = row[Users.id],
            name = row[Users.name],
            registerDate = row[Users.registerDate]
        )
    }
}