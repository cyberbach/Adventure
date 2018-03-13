package net.overmy.adventure;

/*
        Created by Andrey Mikheev on 03.03.2018
        Contact me → http://vk.com/id17317
*/

public enum DEBUG {
    SETTINGS( false ),
    CONTACTS( true ),
    ENTITIES( false ),
    DECAL_ENTITIES( false ),
    PHYSICAL_MESH( false ),
    SHOW_FPS( false ),
    SHOW_MODEL_INFO( false ),
    STAGE( false ),
    DYNAMIC_LEVELS( false ),
    NPC_ACTIONS( false ),
    GAME_MASTER_MODE( false ),
    ;

    private final boolean value;


    public boolean get () {
        return value;
    }


    DEBUG ( boolean value ) {
        this.value = value;
    }
}
