/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamunemployment.lolanalytics.data.control;

import com.teamunemployment.lolanalytics.data.database.DBHelper;
import com.teamunemployment.lolanalytics.models.ParticipantSummary;
import com.teamunemployment.lolanalytics.models.stats.CreepsPerMinDeltas;
import com.teamunemployment.lolanalytics.models.stats.CsDiffPerMinDeltas;
import com.teamunemployment.lolanalytics.models.stats.GoldPerMinDeltas;
import com.teamunemployment.lolanalytics.models.stats.Stats;
import com.teamunemployment.lolanalytics.models.stats.Timeline;
import com.teamunemployment.lolanalytics.models.stats.XpDiffPerMinDeltas;
import com.teamunemployment.lolanalytics.models.stats.XpPerMinDeltas;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author jek40
 */
public class ParticipantSummaryTests {
    
    private DBHelper dbHelper;
    private TimelineControl timelineControl;
    private ParticipantControl participantSummary;
    private RuneControl runeControl;
    private StatControl statControl;
    private MasteriesControl masteriesControl;
    
     /**
     * Prepare for our tests
     */
    public void init() {
        dbHelper = new DBHelper("jdbc:mysql://localhost:3306/local_lolanlaytics", "root", "Idnw2bh2");
        boolean canConnect = dbHelper.Connect();
        CreepsPerMinDeltaControl cmpControl = new CreepsPerMinDeltaControl(dbHelper);
        CsDiffPerMinDeltasControl csdContorl = new CsDiffPerMinDeltasControl(dbHelper);
        
        GoldPerMinDeltasControl gpmControl = new GoldPerMinDeltasControl(dbHelper);
        XpPerMinDeltaControl xpPerMinDeltaControl = new XpPerMinDeltaControl(dbHelper);
        statControl = new StatControl(dbHelper);
        timelineControl = new TimelineControl(cmpControl, csdContorl, gpmControl, xpPerMinDeltaControl, dbHelper);
        participantSummary = new ParticipantControl(dbHelper, runeControl, timelineControl, statControl, masteriesControl);
    }
    
    @Test
    public void TestThatWeCanSaveParticpantSummary() {
        init();
        ParticipantSummary ps = new ParticipantSummary();
        ps.setChampionId(1);
        ps.setHighestAchievedSeasonTier("bronze");
        Stats stats = new Stats();
        stats.setAssists(1);
        stats.setChampLevel(2);
        stats.setCombatPlayerScore(3);
        stats.setDeaths(4);
        stats.setDoubleKills(5);
        stats.setFirstBloodAssist(true);
        stats.setFirstBloodKill(false);
        stats.setFirstInhibitorAssist(true);
        stats.setFirstInhibitorKill(false);
        stats.setGoldEarned(43);
        stats.setGoldSpent(43);
        stats.setId(43);
        stats.setInhibitorKills(43);
        stats.setItem0(1);
        stats.setItem1(2);
        stats.setItem2(3);
        stats.setItem3(3);
        stats.setItem4(3);
        stats.setItem5(3);
        stats.setItem6(3);
        stats.setKillingSprees(3);
        stats.setKills(3);
        stats.setLargestCriticalStrike(3);
        stats.setLargestKillingSpree(3);
        stats.setLargestMultiKill(3);
        stats.setMagicDamageDealt(3);
        stats.setMagicDamageDealtToChampions(3);
        stats.setMagicDamageTaken(4);
        stats.setMinionsKilled(4);
        stats.setNeutralMinionsKilled(4);
        stats.setNeutralMinionsKilledEnemyJungle(4);
        stats.setNeutralMinionsKilledTeamJungle(3);
        stats.setObjectivePlayerScore(4);
        stats.setPentaKills(3);
        stats.setPhysicalDamageDealt(3);
        stats.setPhysicalDamageDealtToChampions(3);
        stats.setPhysicalDamageTaken(3);
        stats.setQuadraKills(3);
        stats.setSightWardsBoughtInGame(3);
        stats.setTotalDamageDealt(3);
        stats.setTotalDamageDealtToChampions(3);
        stats.setTotalDamageTaken(3);
        stats.setTotalHeal(3);
        stats.setTotalPlayerScore(3);
        stats.setTotalScoreRank(4);
        stats.setTotalTimeCrowdControlDealt(4);
        stats.setTotalUnitsHealed(4);
        stats.setTowerKills(5);
        stats.setTripleKills(5);
        stats.setTrueDamageDealt(5);
        stats.setTrueDamageDealtToChampions(5);
        stats.setTrueDamageTaken(5);
        stats.setUnrealKills(5);
        stats.setVisionWardsBoughtInGame(5);
        stats.setWardsKilled(5);
        stats.setWardsPlaced(5);
        stats.setWinner(true);
        ps.setSpell1Id(1);
        ps.setSpell2Id(2);
        ps.setStats(stats);
        
         Timeline timeline = new Timeline();
        CreepsPerMinDeltas creepsPerMinDeltas = new CreepsPerMinDeltas();
        creepsPerMinDeltas.setId(444);
        creepsPerMinDeltas.setTenToTwenty(12.1);
        creepsPerMinDeltas.setThirtyToEnd(9.0);
        creepsPerMinDeltas.setTwentyToThirty(13.1);
        creepsPerMinDeltas.setZeroToTen(8.3);
        timeline.setCreepsPerMinDeltas(creepsPerMinDeltas);
        
        CsDiffPerMinDeltas csDiffPerMinDeltas = new CsDiffPerMinDeltas();
        csDiffPerMinDeltas.setId(444);
        csDiffPerMinDeltas.setTenToTwenty(12.1);
        csDiffPerMinDeltas.setThirtyToEnd(9.0);
        csDiffPerMinDeltas.setTwentyToThirty(13.1);
        csDiffPerMinDeltas.setZeroToTen(8.3);
        timeline.setCsDiffPerMinDeltas(csDiffPerMinDeltas);
        
        GoldPerMinDeltas goldPerMinDeltas = new GoldPerMinDeltas();
        goldPerMinDeltas.setId(444);
        goldPerMinDeltas.setTenToTwenty(12.1);
        goldPerMinDeltas.setThirtyToEnd(9.0);
        goldPerMinDeltas.setTwentyToThirty(13.1);
        goldPerMinDeltas.setZeroToTen(8.3);
        timeline.setGoldPerMinDeltas(goldPerMinDeltas);
        
        XpPerMinDeltas xpPerMinDeltas = new XpPerMinDeltas();
        xpPerMinDeltas.setId(444);
        xpPerMinDeltas.setTenToTwenty(12.1);
        xpPerMinDeltas.setThirtyToEnd(9.0);
        xpPerMinDeltas.setTwentyToThirty(13.1);
        xpPerMinDeltas.setZeroToTen(8.3);
        timeline.setXpPerMinDeltas(xpPerMinDeltas);
        
        XpDiffPerMinDeltas xpDiffPerMinDeltas = new XpDiffPerMinDeltas();
        xpDiffPerMinDeltas.setId(444);
        xpDiffPerMinDeltas.setTenToTwenty(12.1);
        xpDiffPerMinDeltas.setThirtyToEnd(9.0);
        xpDiffPerMinDeltas.setTwentyToThirty(13.1);
        xpDiffPerMinDeltas.setZeroToTen(8.3);
        timeline.setXpDiffPerMinDeltas(xpDiffPerMinDeltas);
        timeline.setRole("JUNGLE");
        timeline.setLane("JUNGLE");
        ps.setTeamId(100);
        ps.setTimeline(timeline);
        ps.setParticipantId(12);
        int id0 = participantSummary.saveParticipant(ps, 1, "SEASON2016");
        int id = participantSummary.saveParticipant(ps, 1, "SEASON2016");
        System.out.println("Id of participant is: " + id);
        ParticipantSummary ps2 = participantSummary.getParticipantSummary(id);
        Assert.assertTrue(ps2.getTimeline().getRole().equals("JUNGLE"));
    }
}
