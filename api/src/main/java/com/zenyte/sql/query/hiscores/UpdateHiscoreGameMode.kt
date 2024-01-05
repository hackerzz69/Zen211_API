package com.zenyte.sql.query.hiscores

import com.zenyte.api.model.GameModeUpdate
import com.zenyte.sql.NoneResult
import com.zenyte.sql.SQLRunnable
import com.zenyte.sql.config.DatabaseCredential

/**
 * @author Corey
 * @since 07/06/19
 */
class UpdateHiscoreGameMode(private val userId: Int,
                            private val changes: GameModeUpdate) : SQLRunnable() {
    
    override fun execute(auth: DatabaseCredential): Pair<NoneResult, Exception?> {
//        val updateQuery = "UPDATE skill_hiscores set xp_mode = ? WHERE userid = ? AND mode = ? AND xp_mode = ?"
//
//        try {
//            HikariPool.getConnection(auth, "zenyte_main").use { con ->
//                con.prepareStatement(updateQuery).use {
//                    it.setInt(1, changes.newMode.index)
//                    it.setInt(2, userId)
//                    it.setInt(3, changes.gameMode.id)
//                    it.setInt(4, changes.oldMode.index)
//                    it.execute()
//                    return Pair(NoneResult(it.resultSet), null)
//                }
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//            return Pair(NoneResult(null), e)
//        }
        return Pair(NoneResult(null), null)
    }
    
}
