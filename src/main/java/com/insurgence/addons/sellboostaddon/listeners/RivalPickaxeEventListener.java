package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import me.rivaldev.pickaxes.api.events.PickaxeMoneyReceiveEnchant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class RivalPickaxeEventListener implements Listener {

    @EventHandler
    private void onReceive(PickaxeMoneyReceiveEnchant event) {
        double multi = AddonUtil.getMulti(event.getPlayer());

        if (multi > 0) {
            event.setMoney(AddonUtil.calculateAmount(event.getMoney(), multi));
        }
    }
}
