package theReaper.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import theReaper.DefaultMod;
import theReaper.cards.CrystalRose;
import theReaper.util.TextureLoader;

import static theReaper.DefaultMod.makeRelicOutlinePath;
import static theReaper.DefaultMod.makeRelicPath;

public class OldCharmRelic extends CustomRelic {


    // ID, images, text.
    public static final String ID = DefaultMod.makeID("OldCharmRelic");

    private static final Logger logger = LogManager.getLogger(OldCharmRelic.class.getName());

    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("oldcharm_relic.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("oldcharm_relic.png"));

    public boolean usedThisCombat = false;

    public OldCharmRelic() {
        super(ID, IMG, OUTLINE, RelicTier.STARTER, LandingSound.MAGICAL);
    }

    // The action for this relic is checked in CardGroup, patched with CardGroupOldCharmPatch

    @Override
    public void atBattleStart()
    {
        usedThisCombat = false;
        this.pulse = true;
        beginPulse();
    }

    public void recordUse(AbstractCard c)
    {
        logger.info("Old Charm Activated. Stopping exhaust of " + c.cardID + " and moving it to discard.");
    }

    public void onVictory() { this.pulse = false; }

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
