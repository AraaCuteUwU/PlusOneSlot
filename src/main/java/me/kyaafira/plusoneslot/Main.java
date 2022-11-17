package me.kyaafira.plusoneslot;

import dev.waterdog.waterdogpe.event.defaults.ProxyPingEvent;
import dev.waterdog.waterdogpe.event.defaults.ProxyQueryEvent;
import dev.waterdog.waterdogpe.plugin.Plugin;

public class Main extends Plugin{

    @Override
    public void onEnable(){
        this.initEvents();
    }

    private void initEvents(){
        this.getProxy().getEventManager().subscribe(ProxyPingEvent.class, Main::onPing);
        this.getProxy().getEventManager().subscribe(ProxyQueryEvent.class, Main::onQuery);
    }

    public static void onPing(ProxyPingEvent event){
        event.setMaximumPlayerCount(event.getPlayerCount() + 1);
    }

    public static void onQuery(ProxyQueryEvent event){
        event.setMaximumPlayerCount(event.getPlayerCount() + 1);
    }
}