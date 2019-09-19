package theReaper.cards;

import basemod.helpers.TooltipInfo;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.BetterDiscardPileToHandAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theReaper.DefaultMod;
import theReaper.actions.DrawCardFromDiscardAction;
import theReaper.powers.BleedPower;

import java.util.ArrayList;

public class Impatience extends AbstractCustomCard {

    public static final String ID = DefaultMod.makeID("Impatience");

    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;

    private static final int COST = 1;

    public Impatience() {

        super(ID, COST, TYPE, RARITY, TARGET);
        magicNumber = baseMagicNumber = 1;
        magicNumberUp = 1;

    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

         act(new DrawCardFromDiscardAction(p,magicNumber)); // draw cards
        //AbstractDungeon.actionManager.addToBottom(new BetterDiscardPileToHandAction(1));
    }


}