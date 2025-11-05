package me.ichun.mods.morph.common.packet;

import io.netty.buffer.ByteBuf;
import me.ichun.mods.ichunutil.common.core.network.AbstractPacket;
import me.ichun.mods.morph.common.Morph;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.relauncher.Side;

public class PacketToggleMorphing extends AbstractPacket
{
    public String bool;

    public PacketToggleMorphing(){}

    public PacketToggleMorphing(String bool)
    {
        this.bool = bool;
    }

    @Override
    public void writeTo(ByteBuf buffer)
    {
        ByteBufUtils.writeUTF8String(buffer, bool);
    }

    @Override
    public void readFrom(ByteBuf buffer)
    {
        bool = ByteBufUtils.readUTF8String(buffer);
    }

    @Override
    public void execute(Side side, EntityPlayer player)
    {
        if (bool.equals(Boolean.TRUE.toString())) {
            Morph.eventHandlerClient.canMorph = true;
        }
        else {
            Morph.eventHandlerClient.canMorph = false;
        }
            
    }

    @Override
    public Side receivingSide()
    {
        return Side.CLIENT;
    }
}
