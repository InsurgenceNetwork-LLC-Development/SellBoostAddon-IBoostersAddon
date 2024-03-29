package com.insurgence.addons.sellboostaddon.listeners;

import com.insurgence.addons.sellboostaddon.utils.AddonUtil;
import net.brcdev.shopgui.event.ShopPreTransactionEvent;
import net.brcdev.shopgui.shop.ShopManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class ShopGUIPlusListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onTransact(ShopPreTransactionEvent event) {
        if (event.getShopAction().equals(ShopManager.ShopAction.BUY)) {
            return;
        }

        double multi = AddonUtil.getMulti(event.getPlayer());

        if (multi > 0) {
            event.setPrice(AddonUtil.calculateAmount(event.getPrice(), multi));
        }
    }
}
