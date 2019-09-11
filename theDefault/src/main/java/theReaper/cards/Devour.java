package theReaper.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theReaper.DefaultMod;
import theReaper.actions.DevourAction;
import theReaper.powers.BleedPower;

public class Devour extends AbstractCustomCard {

    public static final String ID = DefaultMod.makeID("Devour");

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;

    private static final int COST = 2;

    public Devour()
    {

        super(ID, COST, TYPE, RARITY, TARGET);
        baseDamage = 12;
        damageUp = 3;
        baseMagicNumber = magicNumber = 10;

    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        act(new DevourAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), this.magicNumber));

    }


}
