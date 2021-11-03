package ohtu.ohtuvarasto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);

    }


    @Test
    public void varastoNegatiivinen() {

        varasto = new Varasto(-10);
        assertEquals(0, varasto.getTilavuus(),vertailuTarkkuus);
    }

    @Test
    public void varastoSetUpTilavuus() {
        varasto = new Varasto(10, 8);

        assertEquals(10,varasto.getTilavuus(),vertailuTarkkuus);
    }
    @Test
    public void varastoSetUpTilavuusSaldo() {
        varasto = new Varasto(10, 8);

        assertEquals(8,varasto.getSaldo(),vertailuTarkkuus);
    }

    @Test
    public void varastoSetUpNegatiivinenTilavuus() {
        varasto = new Varasto(-10, 200);

        assertEquals(0,varasto.getTilavuus(),vertailuTarkkuus);
    }
    @Test
    public void varastoSetUpNegatiivinenTilavuusSaldo() {

        varasto = new Varasto(-10, 200);

        assertEquals(0,varasto.getSaldo(),vertailuTarkkuus);
    }

    @Test
    public void varastoSetUpNegatiivinenSaldoTilavuus() {
        varasto = new Varasto(10, -200);

        assertEquals(10,varasto.getTilavuus(),vertailuTarkkuus);
    }
    @Test
    public void varastoSetUpNegatiivinenSaldo() {
        varasto = new Varasto(10, -200);

        assertEquals(0,varasto.getSaldo(),vertailuTarkkuus);
    }

    @Test
    public void varastoSetUpSaldo() {
        varasto = new Varasto(10, 200);

        assertEquals(10,varasto.getTilavuus(),vertailuTarkkuus);
    }
    @Test
    public void varastoSetUpTaysSaldo() {
        varasto = new Varasto(10, 200);

        assertEquals(10,varasto.getSaldo(),vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void lisaaLiikaaVarastoon() {
        varasto.lisaaVarastoon(varasto.getTilavuus()*20);

        assertEquals(varasto.getTilavuus(),varasto.getSaldo(),vertailuTarkkuus);
    }

    @Test
    public void lisaaNegatiivinenVarastoon() {
        double maara = varasto.getSaldo();
        varasto.lisaaVarastoon(-10);

        assertEquals(maara,varasto.getSaldo(),vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void otaNegatiivinen() {

        assertEquals(0.0, varasto.otaVarastosta(-1),vertailuTarkkuus);
    }

    @Test

    public void otaYliSaldonSaatuMaara() {
        double maara = varasto.getSaldo();
        assertEquals(maara, varasto.otaVarastosta(varasto.getSaldo()*3),vertailuTarkkuus);
    }

    @Test

    public void otaYliSaldonSaldoNolla() {
        varasto.lisaaVarastoon(2);
       varasto.otaVarastosta(varasto.getSaldo()*3);
        assertEquals(0, varasto.getSaldo(),vertailuTarkkuus);
    }

    @Test
    public void StringReturn() {

        String varastoTilanne =  "saldo = " + varasto.getSaldo() + ", vielä tilaa " + varasto.getTilavuus();
        assertEquals(varastoTilanne,varasto.toString());
    }

}