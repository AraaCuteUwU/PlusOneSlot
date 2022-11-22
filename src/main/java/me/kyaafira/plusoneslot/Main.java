package me.kyaafira.plusoneslot;

import dev.waterdog.waterdogpe.event.defaults.ProxyPingEvent;
import dev.waterdog.waterdogpe.event.defaults.ProxyQueryEvent;
import dev.waterdog.waterdogpe.plugin.Plugin;

public class Main extends Plugin{

    @Override
    public void onEnable(){
        this.saveResource("config.yml");
        initEvents();
    }

    private void initEvents(){
        this.getProxy().getEventManager().subscribe(ProxyPingEvent.class, this::onPing);
        this.getProxy().getEventManager().subscribe(ProxyQueryEvent.class, this::onQuery);
    }

    public void onPing(ProxyPingEvent event){
        event.setMaximumPlayerCount(event.getPlayerCount() + this.getConfig().getInt("max-slots"));
    }

    public void onQuery(ProxyQueryEvent event){
        event.setMaximumPlayerCount(event.getPlayerCount() + this.getConfig().getInt("max-slots"));
    }
}
