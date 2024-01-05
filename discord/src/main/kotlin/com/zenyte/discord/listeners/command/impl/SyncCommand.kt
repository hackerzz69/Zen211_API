package com.zenyte.discord.listeners.command.impl

import com.zenyte.discord.Api
import com.zenyte.discord.listeners.command.Command
import mu.KotlinLogging
import net.dv8tion.jda.api.entities.Message
import okhttp3.FormBody
import okhttp3.Request

/**
 * @author Corey
 * @since 01/06/2019
 */
class SyncCommand : Command {
    
    private val logger = KotlinLogging.logger {}
    
    override val identifiers = arrayOf("sync")
    
    override val description = "" // Syncs your Discord roles based on your forum account.
    
    override fun execute(message: Message, identifier: String) {
        return
//        val user = message.member!!.user
//
//        if (!DiscordBot.userIsVerified(message.member!!)) {
//            message.channel.sendMessage("${user.asMention} you need to be verified to use this command!").queue()
//            return
//        }
//
//        try {
//            val memberId = Discord.getVerifiedMemberId(user.idLong)
//            sync(memberId, user.idLong)
//            message.channel.addReactionById(message.id, "\u2705").queue() // :heavy_check_mark:
//        } catch (e: Exception) {
//            message.channel.addReactionById(message.id, "\u26A0").queue() // :warning:
//            logger.error { "Error syncing roles for '${user.name}'" }
//            e.printStackTrace()
//        }
    
    }
    
    private fun sync(memberId: Int, discordMemberId: Long) {
        val body = FormBody.Builder()
                .add("memberId", memberId.toString())
                .add("discordId", discordMemberId.toString())
                .build()
        
        val request = Request.Builder()
                .url(Api.getApiRoot()
                        .addPathSegment("discord")
                        .addPathSegment("sync")
                        .build())
                .post(body)
                .build()
        
        Api.client.newCall(request).execute()
    }
    
}