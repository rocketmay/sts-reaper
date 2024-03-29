package theReaper.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.SuicideAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import com.megacrit.cardcrawl.vfx.combat.InflameEffect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import theReaper.DefaultMod;
import theReaper.patches.AbstractPlayerSoulsPatch;
import theReaper.relics.EggSlicerRelic;
import theReaper.souls.AbstractSoul;
import theReaper.souls.HollowSoul;
import theReaper.souls.KingSoul;
import theReaper.souls.LostSoul;
import theReaper.util.SoulManager;

public class RemoveSoulAction extends AbstractGameAction {


    private AbstractPlayer p;
    private AbstractSoul soul;
    public static final Logger logger = LogManager.getLogger(RemoveSoulAction.class.getName());
    public boolean noDuration = false;

    public RemoveSoulAction(final AbstractPlayer p, AbstractSoul s) {
        setValues(p, p, 0);

        this.actionType = ActionType.SPECIAL;
        this.duration = 0.5F;
        this.soul = s;


    }

    public RemoveSoulAction(final AbstractPlayer p, AbstractSoul s, boolean noDuration)
    {
        setValues(p, p, 0);

        this.actionType = ActionType.SPECIAL;
        this.duration = 0.5F;
        this.soul = s;

        this.noDuration = noDuration;
    }

    @Override
    public void update() {
        if (shouldCancelAction()) {
            this.isDone = true;

            return;
        }

        if (this.duration == 0.5F) {
            logger.info("Removing soul from player souls: " + soul.name);
            String soulName = soul.getSoulName();
            AbstractPlayerSoulsPatch.souls.get(AbstractDungeon.player).remove(soul.index);
            SoulManager.updateSoulIndices();
            if(noDuration = true)
            {
                this.isDone = true;
            }

            if(AbstractDungeon.player.hasRelic(EggSlicerRelic.ID))
            {
                if (soulName == KingSoul.soulName) {
                    AbstractDungeon.actionManager.addToBottom(new SoulGemAction(new HollowSoul()));
                    AbstractDungeon.actionManager.addToBottom(new SoulGemAction(new LostSoul()));
                } else if (soulName == HollowSoul.soulName)
                {
                    AbstractDungeon.actionManager.addToBottom(new SoulGemAction(new LostSoul()));
                    AbstractDungeon.actionManager.addToBottom(new SoulGemAction(new LostSoul()));

                }
            }
        }

        tickDuration();

    }
}
