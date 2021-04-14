import exceptions.BiometriaComFormatoIncorretoException;
import exceptions.GeolocalizacaoComFormatoIncorretoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CofreTest {
    private Map<String, Pessoa> autorizados;

    @Before
    public void criarHashMapComOsInstrutores() {
        this.autorizados = new HashMap<>();

        List<Pessoa> pessoas = Leitor.buscarPessoas();

        autorizados.put("victor.damke", pessoas.get(0));
        autorizados.put("fabio.blumm", pessoas.get(1));
        autorizados.put("pablo.oliveira", pessoas.get(2));
        autorizados.put("diuly.barreto", pessoas.get(3));
    }

    @Test
    public void deveAbrirCofreQuandoPessoaEstiverNaListaDeAutorizados() throws NoSuchAlgorithmException, BiometriaComFormatoIncorretoException, GeolocalizacaoComFormatoIncorretoException {
        String login = "victor.damke";
        String senha = "SenhaDoVictor";
        Perfil perfil = Perfil.INSTRUTOR;
        double[] geolocalizacao = {-29.686930, -51.127550};
        double[] biometria = {-0.0717240795493126,0.200424239039421,0.0795498192310333,-0.0251115821301937,-0.0814622119069099,0.029400322586298,-0.0213277991861105,-0.121166698634624,0.137610971927643,-0.121532410383224,0.219820812344551,0.0326585657894611,-0.202189430594444,0.0765653625130653,0.00401705782860518,0.0909221544861794,-0.140626832842827,-0.0937680155038834,-0.15438623726368,-0.12654148042202,0.0755802318453789,0.0510320290923119,-0.0419369973242283,0.115638792514801,-0.185452610254288,-0.213810309767723,-0.0835670977830887,-0.0531335696578026,0.194502651691437,-0.0575171895325184,-0.0845270082354546,-0.0414815619587898,-0.185585513710976,-0.00712401419878006,-0.00706483703106642,-0.0405994169414043,-0.0177285149693489,-0.118289694190025,0.197652652859688,0.00473394803702831,-0.124115504324436,0.0695038661360741,0.0517630875110626,0.247236296534538,0.182528674602509,0.0120388949289918,0.0902915671467781,-0.0855348259210587,0.137425035238266,-0.24683965742588,0.070648729801178,0.135296046733856,0.128352895379066,0.13893735408783,0.0129938125610352,-0.260438621044159,0.0118288304656744,0.151524245738983,-0.209388762712479,0.184834316372871,0.0698952227830887,-0.123996213078499,-0.028987143188715,-0.0314105451107025,0.124371588230133,0.089169517159462,-0.102745182812214,-0.176323086023331,0.0989512652158737,-0.208186864852905,0.0151518899947405,0.102145493030548,-0.0984270945191383,-0.202222555875778,-0.251518040895462,0.113038398325443,0.406335115432739,0.292576491832733,-0.160103693604469,0.0283763613551855,-0.0628431364893913,-0.0207597371190786,0.0996167063713074,0.0557213723659515,-0.0873976349830627,-0.107157692313194,-0.0916686803102493,0.117477178573608,0.244352534413338,0.00656623207032681,0.0039253318682313,0.296879529953003,0.0599085837602615,-0.031019264832139,-0.0594459995627403,0.102026894688606,-0.189244881272316,-0.0255255550146103,-0.0100112166255713,0.0563904717564583,-0.0312739089131355,-0.0449331514537334,0.0229957215487957,0.0882981270551682,-0.218520402908325,0.209871992468834,-0.047384861856699,-0.0291850529611111,-0.0479375459253788,-0.0050220899283886,-0.115637965500355,-0.0140184136107564,0.149251565337181,-0.245322212576866,0.15214766561985,0.222329303622246,0.0643958821892738,0.158732324838638,0.0528756827116013,0.0589691326022148,0.0725817978382111,-0.0196244567632675,-0.140394330024719,-0.0864106267690659,0.0804716646671295,-0.130521312355995,0.0442943871021271,0.0199476405978203};
        Cofre cofre = new Cofre(this.autorizados, 0.1, 2);

        // act
        boolean resultado = cofre.abrir(login, perfil, senha, biometria, geolocalizacao);

        // assert
        Assert.assertTrue(resultado);
    }

    @Test
    public void deveManterCofreFechadoQuandoLoginNaoEstiverNaListaDeAutorizados() throws NoSuchAlgorithmException, BiometriaComFormatoIncorretoException, GeolocalizacaoComFormatoIncorretoException {
        String login = "victor.damki";
        String senha = "SenhaDoVictor";
        Perfil perfil = Perfil.INSTRUTOR;
        double[] geolocalizacao = {-29.686930, -51.127550};
        double[] biometria = {-0.0717240795493126,0.200424239039421,0.0795498192310333,-0.0251115821301937,-0.0814622119069099,0.029400322586298,-0.0213277991861105,-0.121166698634624,0.137610971927643,-0.121532410383224,0.219820812344551,0.0326585657894611,-0.202189430594444,0.0765653625130653,0.00401705782860518,0.0909221544861794,-0.140626832842827,-0.0937680155038834,-0.15438623726368,-0.12654148042202,0.0755802318453789,0.0510320290923119,-0.0419369973242283,0.115638792514801,-0.185452610254288,-0.213810309767723,-0.0835670977830887,-0.0531335696578026,0.194502651691437,-0.0575171895325184,-0.0845270082354546,-0.0414815619587898,-0.185585513710976,-0.00712401419878006,-0.00706483703106642,-0.0405994169414043,-0.0177285149693489,-0.118289694190025,0.197652652859688,0.00473394803702831,-0.124115504324436,0.0695038661360741,0.0517630875110626,0.247236296534538,0.182528674602509,0.0120388949289918,0.0902915671467781,-0.0855348259210587,0.137425035238266,-0.24683965742588,0.070648729801178,0.135296046733856,0.128352895379066,0.13893735408783,0.0129938125610352,-0.260438621044159,0.0118288304656744,0.151524245738983,-0.209388762712479,0.184834316372871,0.0698952227830887,-0.123996213078499,-0.028987143188715,-0.0314105451107025,0.124371588230133,0.089169517159462,-0.102745182812214,-0.176323086023331,0.0989512652158737,-0.208186864852905,0.0151518899947405,0.102145493030548,-0.0984270945191383,-0.202222555875778,-0.251518040895462,0.113038398325443,0.406335115432739,0.292576491832733,-0.160103693604469,0.0283763613551855,-0.0628431364893913,-0.0207597371190786,0.0996167063713074,0.0557213723659515,-0.0873976349830627,-0.107157692313194,-0.0916686803102493,0.117477178573608,0.244352534413338,0.00656623207032681,0.0039253318682313,0.296879529953003,0.0599085837602615,-0.031019264832139,-0.0594459995627403,0.102026894688606,-0.189244881272316,-0.0255255550146103,-0.0100112166255713,0.0563904717564583,-0.0312739089131355,-0.0449331514537334,0.0229957215487957,0.0882981270551682,-0.218520402908325,0.209871992468834,-0.047384861856699,-0.0291850529611111,-0.0479375459253788,-0.0050220899283886,-0.115637965500355,-0.0140184136107564,0.149251565337181,-0.245322212576866,0.15214766561985,0.222329303622246,0.0643958821892738,0.158732324838638,0.0528756827116013,0.0589691326022148,0.0725817978382111,-0.0196244567632675,-0.140394330024719,-0.0864106267690659,0.0804716646671295,-0.130521312355995,0.0442943871021271,0.0199476405978203};
        Cofre cofre = new Cofre(this.autorizados, 0.1, 2);

        // act
        boolean resultado = cofre.abrir(login, perfil, senha, biometria, geolocalizacao);

        // assert
        Assert.assertFalse(resultado);
    }

    @Test
    public void deveManterCofreFechadoQuandoSenhaEstiverIncorreta() throws NoSuchAlgorithmException, BiometriaComFormatoIncorretoException, GeolocalizacaoComFormatoIncorretoException {
        String login = "victor.damke";
        String senha = "SenhaDoVitao";
        Perfil perfil = Perfil.INSTRUTOR;
        double[] geolocalizacao = {-29.686930, -51.127550};
        double[] biometria = {-0.0717240795493126,0.200424239039421,0.0795498192310333,-0.0251115821301937,-0.0814622119069099,0.029400322586298,-0.0213277991861105,-0.121166698634624,0.137610971927643,-0.121532410383224,0.219820812344551,0.0326585657894611,-0.202189430594444,0.0765653625130653,0.00401705782860518,0.0909221544861794,-0.140626832842827,-0.0937680155038834,-0.15438623726368,-0.12654148042202,0.0755802318453789,0.0510320290923119,-0.0419369973242283,0.115638792514801,-0.185452610254288,-0.213810309767723,-0.0835670977830887,-0.0531335696578026,0.194502651691437,-0.0575171895325184,-0.0845270082354546,-0.0414815619587898,-0.185585513710976,-0.00712401419878006,-0.00706483703106642,-0.0405994169414043,-0.0177285149693489,-0.118289694190025,0.197652652859688,0.00473394803702831,-0.124115504324436,0.0695038661360741,0.0517630875110626,0.247236296534538,0.182528674602509,0.0120388949289918,0.0902915671467781,-0.0855348259210587,0.137425035238266,-0.24683965742588,0.070648729801178,0.135296046733856,0.128352895379066,0.13893735408783,0.0129938125610352,-0.260438621044159,0.0118288304656744,0.151524245738983,-0.209388762712479,0.184834316372871,0.0698952227830887,-0.123996213078499,-0.028987143188715,-0.0314105451107025,0.124371588230133,0.089169517159462,-0.102745182812214,-0.176323086023331,0.0989512652158737,-0.208186864852905,0.0151518899947405,0.102145493030548,-0.0984270945191383,-0.202222555875778,-0.251518040895462,0.113038398325443,0.406335115432739,0.292576491832733,-0.160103693604469,0.0283763613551855,-0.0628431364893913,-0.0207597371190786,0.0996167063713074,0.0557213723659515,-0.0873976349830627,-0.107157692313194,-0.0916686803102493,0.117477178573608,0.244352534413338,0.00656623207032681,0.0039253318682313,0.296879529953003,0.0599085837602615,-0.031019264832139,-0.0594459995627403,0.102026894688606,-0.189244881272316,-0.0255255550146103,-0.0100112166255713,0.0563904717564583,-0.0312739089131355,-0.0449331514537334,0.0229957215487957,0.0882981270551682,-0.218520402908325,0.209871992468834,-0.047384861856699,-0.0291850529611111,-0.0479375459253788,-0.0050220899283886,-0.115637965500355,-0.0140184136107564,0.149251565337181,-0.245322212576866,0.15214766561985,0.222329303622246,0.0643958821892738,0.158732324838638,0.0528756827116013,0.0589691326022148,0.0725817978382111,-0.0196244567632675,-0.140394330024719,-0.0864106267690659,0.0804716646671295,-0.130521312355995,0.0442943871021271,0.0199476405978203};
        Cofre cofre = new Cofre(this.autorizados, 0.1, 2);

        // act
        boolean resultado = cofre.abrir(login, perfil, senha, biometria, geolocalizacao);

        // assert
        Assert.assertFalse(resultado);
    }

    @Test
    public void deveManterCofreFechadoQuandoPerfilEstiverIncorreto() throws NoSuchAlgorithmException, BiometriaComFormatoIncorretoException, GeolocalizacaoComFormatoIncorretoException {
        String login = "victor.damke";
        String senha = "SenhaDoVictor";
        Perfil perfil = Perfil.CRESCER;
        double[] geolocalizacao = {-29.686930, -51.127550};
        double[] biometria = {-0.0717240795493126,0.200424239039421,0.0795498192310333,-0.0251115821301937,-0.0814622119069099,0.029400322586298,-0.0213277991861105,-0.121166698634624,0.137610971927643,-0.121532410383224,0.219820812344551,0.0326585657894611,-0.202189430594444,0.0765653625130653,0.00401705782860518,0.0909221544861794,-0.140626832842827,-0.0937680155038834,-0.15438623726368,-0.12654148042202,0.0755802318453789,0.0510320290923119,-0.0419369973242283,0.115638792514801,-0.185452610254288,-0.213810309767723,-0.0835670977830887,-0.0531335696578026,0.194502651691437,-0.0575171895325184,-0.0845270082354546,-0.0414815619587898,-0.185585513710976,-0.00712401419878006,-0.00706483703106642,-0.0405994169414043,-0.0177285149693489,-0.118289694190025,0.197652652859688,0.00473394803702831,-0.124115504324436,0.0695038661360741,0.0517630875110626,0.247236296534538,0.182528674602509,0.0120388949289918,0.0902915671467781,-0.0855348259210587,0.137425035238266,-0.24683965742588,0.070648729801178,0.135296046733856,0.128352895379066,0.13893735408783,0.0129938125610352,-0.260438621044159,0.0118288304656744,0.151524245738983,-0.209388762712479,0.184834316372871,0.0698952227830887,-0.123996213078499,-0.028987143188715,-0.0314105451107025,0.124371588230133,0.089169517159462,-0.102745182812214,-0.176323086023331,0.0989512652158737,-0.208186864852905,0.0151518899947405,0.102145493030548,-0.0984270945191383,-0.202222555875778,-0.251518040895462,0.113038398325443,0.406335115432739,0.292576491832733,-0.160103693604469,0.0283763613551855,-0.0628431364893913,-0.0207597371190786,0.0996167063713074,0.0557213723659515,-0.0873976349830627,-0.107157692313194,-0.0916686803102493,0.117477178573608,0.244352534413338,0.00656623207032681,0.0039253318682313,0.296879529953003,0.0599085837602615,-0.031019264832139,-0.0594459995627403,0.102026894688606,-0.189244881272316,-0.0255255550146103,-0.0100112166255713,0.0563904717564583,-0.0312739089131355,-0.0449331514537334,0.0229957215487957,0.0882981270551682,-0.218520402908325,0.209871992468834,-0.047384861856699,-0.0291850529611111,-0.0479375459253788,-0.0050220899283886,-0.115637965500355,-0.0140184136107564,0.149251565337181,-0.245322212576866,0.15214766561985,0.222329303622246,0.0643958821892738,0.158732324838638,0.0528756827116013,0.0589691326022148,0.0725817978382111,-0.0196244567632675,-0.140394330024719,-0.0864106267690659,0.0804716646671295,-0.130521312355995,0.0442943871021271,0.0199476405978203};
        Cofre cofre = new Cofre(this.autorizados, 0.1, 2);

        // act
        boolean resultado = cofre.abrir(login, perfil, senha, biometria, geolocalizacao);

        // assert
        Assert.assertFalse(resultado);
    }

    @Test
    public void deveManterCofreFechadoQuandoGeolocalizacaoForMaisDistanteQueOMaximoPermitido() throws NoSuchAlgorithmException, BiometriaComFormatoIncorretoException, GeolocalizacaoComFormatoIncorretoException {
        String login = "victor.damke";
        String senha = "SenhaDoVictor";
        Perfil perfil = Perfil.INSTRUTOR;
        double[] geolocalizacao = {31.2304, 121.4737};
        double[] biometria = {-0.0717240795493126,0.200424239039421,0.0795498192310333,-0.0251115821301937,-0.0814622119069099,0.029400322586298,-0.0213277991861105,-0.121166698634624,0.137610971927643,-0.121532410383224,0.219820812344551,0.0326585657894611,-0.202189430594444,0.0765653625130653,0.00401705782860518,0.0909221544861794,-0.140626832842827,-0.0937680155038834,-0.15438623726368,-0.12654148042202,0.0755802318453789,0.0510320290923119,-0.0419369973242283,0.115638792514801,-0.185452610254288,-0.213810309767723,-0.0835670977830887,-0.0531335696578026,0.194502651691437,-0.0575171895325184,-0.0845270082354546,-0.0414815619587898,-0.185585513710976,-0.00712401419878006,-0.00706483703106642,-0.0405994169414043,-0.0177285149693489,-0.118289694190025,0.197652652859688,0.00473394803702831,-0.124115504324436,0.0695038661360741,0.0517630875110626,0.247236296534538,0.182528674602509,0.0120388949289918,0.0902915671467781,-0.0855348259210587,0.137425035238266,-0.24683965742588,0.070648729801178,0.135296046733856,0.128352895379066,0.13893735408783,0.0129938125610352,-0.260438621044159,0.0118288304656744,0.151524245738983,-0.209388762712479,0.184834316372871,0.0698952227830887,-0.123996213078499,-0.028987143188715,-0.0314105451107025,0.124371588230133,0.089169517159462,-0.102745182812214,-0.176323086023331,0.0989512652158737,-0.208186864852905,0.0151518899947405,0.102145493030548,-0.0984270945191383,-0.202222555875778,-0.251518040895462,0.113038398325443,0.406335115432739,0.292576491832733,-0.160103693604469,0.0283763613551855,-0.0628431364893913,-0.0207597371190786,0.0996167063713074,0.0557213723659515,-0.0873976349830627,-0.107157692313194,-0.0916686803102493,0.117477178573608,0.244352534413338,0.00656623207032681,0.0039253318682313,0.296879529953003,0.0599085837602615,-0.031019264832139,-0.0594459995627403,0.102026894688606,-0.189244881272316,-0.0255255550146103,-0.0100112166255713,0.0563904717564583,-0.0312739089131355,-0.0449331514537334,0.0229957215487957,0.0882981270551682,-0.218520402908325,0.209871992468834,-0.047384861856699,-0.0291850529611111,-0.0479375459253788,-0.0050220899283886,-0.115637965500355,-0.0140184136107564,0.149251565337181,-0.245322212576866,0.15214766561985,0.222329303622246,0.0643958821892738,0.158732324838638,0.0528756827116013,0.0589691326022148,0.0725817978382111,-0.0196244567632675,-0.140394330024719,-0.0864106267690659,0.0804716646671295,-0.130521312355995,0.0442943871021271,0.0199476405978203};
        Cofre cofre = new Cofre(this.autorizados, 0.1, 2);

        // act
        boolean resultado = cofre.abrir(login, perfil, senha, biometria, geolocalizacao);

        // assert
        Assert.assertFalse(resultado);
    }

    @Test
    public void deveManterCofreFechadoQuandoBiometriaForMaisDiferenteQueOMaximoPermitido() throws NoSuchAlgorithmException, BiometriaComFormatoIncorretoException, GeolocalizacaoComFormatoIncorretoException {
        String login = "victor.damke";
        String senha = "SenhaDoVictor";
        Perfil perfil = Perfil.INSTRUTOR;
        double[] geolocalizacao = {-29.686930, -51.127550};
        double[] biometria = {-0.0990239232778549,0.0079084150493145,0.154727384448051,0.0530175343155861,-0.0923811569809914,-0.0948156416416168,-0.0481217801570892,-0.0525231584906578,0.0380620770156384,-0.0963722243905067,0.22942017018795,-0.0657409951090813,-0.189451590180397,-0.0553178712725639,0.00231799017637968,0.0918812602758408,-0.0987720638513565,-0.0735803693532944,-0.0681153386831284,-0.0827769637107849,0.0474614575505257,0.0251139495521784,0.0274558458477259,0.0618586130440235,-0.0636953264474869,-0.369678676128387,-0.0821518003940582,-0.124783113598824,0.0264478046447039,-0.0966269969940186,-0.0300350803881884,0.0698734670877457,-0.122671209275723,-0.0212354175746441,-0.00143692269921303,0.113546542823315,-0.126733422279358,-0.0815743505954742,0.232591986656189,-0.099852442741394,-0.144629836082458,0.00534539157524705,0.0528934299945831,0.219468876719475,0.17560513317585,0.0234149135649204,0.0326487682759762,-0.0176489353179932,0.105610847473145,-0.249942719936371,0.0608094036579132,0.166817769408226,0.0807783007621765,0.0864948704838753,0.162840753793716,-0.116054765880108,0.020589392632246,0.0997036099433899,-0.101825654506683,0.10982770472765,-0.0276624690741301,-0.107970245182514,0.00866368599236012,-0.0502893999218941,0.151621967554092,0.0433148927986622,-0.0540333576500416,-0.0674496591091156,0.115064851939678,-0.198397487401962,-0.0560042299330235,0.137257099151611,-0.124091848731041,-0.229157373309135,-0.227740004658699,0.0579754337668419,0.392288058996201,0.16056102514267,-0.147572666406631,0.0618127137422562,0.0336878187954426,-0.0937094613909721,0.123042441904545,0.0857021138072014,-0.0536199659109116,-0.00412993598729372,-0.113246209919453,0.102360159158707,0.184401303529739,-0.030696602538228,-0.019819937646389,0.224367797374725,-0.0061148963868618,0.0684718191623688,0.0555245541036129,-0.0324945487082005,0.00130299851298332,-0.00511670671403408,-0.127895787358284,0.01016915589571,0.13160939514637,-0.111353568732738,-0.0311722066253424,0.00372699275612831,-0.141589999198914,0.0481137335300446,-0.0317297540605068,0.0080631747841835,-0.00106312241405249,-0.0138523196801543,-0.18743209540844,0.0305165685713291,0.189383894205093,-0.238493666052818,0.195571020245552,0.17558628320694,0.0133741619065404,0.127645686268806,0.0772313624620438,0.0193594396114349,0.0212249159812927,-0.125648394227028,-0.156481698155403,-0.0290895663201809,0.0913827419281006,0.0337834134697914,0.0298458747565746,0.0147692291066051};
        Cofre cofre = new Cofre(this.autorizados, 0.1, 2);

        // act
        boolean resultado = cofre.abrir(login, perfil, senha, biometria, geolocalizacao);

        // assert
        Assert.assertFalse(resultado);
    }

    @Test(expected = BiometriaComFormatoIncorretoException.class)
    public void deveLancarExcecaoDeBiometriaComFormatoIncorretoQuandoFaltaremValoresNaBiometria() throws NoSuchAlgorithmException, BiometriaComFormatoIncorretoException, GeolocalizacaoComFormatoIncorretoException {
        String login = "victor.damke";
        String senha = "SenhaDoVictor";
        Perfil perfil = Perfil.INSTRUTOR;
        double[] geolocalizacao = {-29.686930, -51.127550};
        double[] biometria = {0.0079084150493145,0.154727384448051,0.0530175343155861,-0.0923811569809914,-0.0948156416416168,-0.0481217801570892,-0.0525231584906578,0.0380620770156384,-0.0963722243905067,0.22942017018795,-0.0657409951090813,-0.189451590180397,-0.0553178712725639,0.00231799017637968,0.0918812602758408,-0.0987720638513565,-0.0735803693532944,-0.0681153386831284,-0.0827769637107849,0.0474614575505257,0.0251139495521784,0.0274558458477259,0.0618586130440235,-0.0636953264474869,-0.369678676128387,-0.0821518003940582,-0.124783113598824,0.0264478046447039,-0.0966269969940186,-0.0300350803881884,0.0698734670877457,-0.122671209275723,-0.0212354175746441,-0.00143692269921303,0.113546542823315,-0.126733422279358,-0.0815743505954742,0.232591986656189,-0.099852442741394,-0.144629836082458,0.00534539157524705,0.0528934299945831,0.219468876719475,0.17560513317585,0.0234149135649204,0.0326487682759762,-0.0176489353179932,0.105610847473145,-0.249942719936371,0.0608094036579132,0.166817769408226,0.0807783007621765,0.0864948704838753,0.162840753793716,-0.116054765880108,0.020589392632246,0.0997036099433899,-0.101825654506683,0.10982770472765,-0.0276624690741301,-0.107970245182514,0.00866368599236012,-0.0502893999218941,0.151621967554092,0.0433148927986622,-0.0540333576500416,-0.0674496591091156,0.115064851939678,-0.198397487401962,-0.0560042299330235,0.137257099151611,-0.124091848731041,-0.229157373309135,-0.227740004658699,0.0579754337668419,0.392288058996201,0.16056102514267,-0.147572666406631,0.0618127137422562,0.0336878187954426,-0.0937094613909721,0.123042441904545,0.0857021138072014,-0.0536199659109116,-0.00412993598729372,-0.113246209919453,0.102360159158707,0.184401303529739,-0.030696602538228,-0.019819937646389,0.224367797374725,-0.0061148963868618,0.0684718191623688,0.0555245541036129,-0.0324945487082005,0.00130299851298332,-0.00511670671403408,-0.127895787358284,0.01016915589571,0.13160939514637,-0.111353568732738,-0.0311722066253424,0.00372699275612831,-0.141589999198914,0.0481137335300446,-0.0317297540605068,0.0080631747841835,-0.00106312241405249,-0.0138523196801543,-0.18743209540844,0.0305165685713291,0.189383894205093,-0.238493666052818,0.195571020245552,0.17558628320694,0.0133741619065404,0.127645686268806,0.0772313624620438,0.0193594396114349,0.0212249159812927,-0.125648394227028,-0.156481698155403,-0.0290895663201809,0.0913827419281006,0.0337834134697914,0.0298458747565746,0.0147692291066051};
        Cofre cofre = new Cofre(this.autorizados, 0.1, 2);

        // act
        boolean resultado = cofre.abrir(login, perfil, senha, biometria, geolocalizacao);
    }

    @Test(expected = BiometriaComFormatoIncorretoException.class)
    public void deveLancarExcecaoDeBiometriaComFormatoIncorretoQuandoSobraremValoresNaBiometria() throws NoSuchAlgorithmException, BiometriaComFormatoIncorretoException, GeolocalizacaoComFormatoIncorretoException {
        String login = "victor.damke";
        String senha = "SenhaDoVictor";
        Perfil perfil = Perfil.INSTRUTOR;
        double[] geolocalizacao = {-29.686930, -51.127550};
        double[] biometria = {-0.0990239232778549,-0.0990239232778549,0.0079084150493145,0.154727384448051,0.0530175343155861,-0.0923811569809914,-0.0948156416416168,-0.0481217801570892,-0.0525231584906578,0.0380620770156384,-0.0963722243905067,0.22942017018795,-0.0657409951090813,-0.189451590180397,-0.0553178712725639,0.00231799017637968,0.0918812602758408,-0.0987720638513565,-0.0735803693532944,-0.0681153386831284,-0.0827769637107849,0.0474614575505257,0.0251139495521784,0.0274558458477259,0.0618586130440235,-0.0636953264474869,-0.369678676128387,-0.0821518003940582,-0.124783113598824,0.0264478046447039,-0.0966269969940186,-0.0300350803881884,0.0698734670877457,-0.122671209275723,-0.0212354175746441,-0.00143692269921303,0.113546542823315,-0.126733422279358,-0.0815743505954742,0.232591986656189,-0.099852442741394,-0.144629836082458,0.00534539157524705,0.0528934299945831,0.219468876719475,0.17560513317585,0.0234149135649204,0.0326487682759762,-0.0176489353179932,0.105610847473145,-0.249942719936371,0.0608094036579132,0.166817769408226,0.0807783007621765,0.0864948704838753,0.162840753793716,-0.116054765880108,0.020589392632246,0.0997036099433899,-0.101825654506683,0.10982770472765,-0.0276624690741301,-0.107970245182514,0.00866368599236012,-0.0502893999218941,0.151621967554092,0.0433148927986622,-0.0540333576500416,-0.0674496591091156,0.115064851939678,-0.198397487401962,-0.0560042299330235,0.137257099151611,-0.124091848731041,-0.229157373309135,-0.227740004658699,0.0579754337668419,0.392288058996201,0.16056102514267,-0.147572666406631,0.0618127137422562,0.0336878187954426,-0.0937094613909721,0.123042441904545,0.0857021138072014,-0.0536199659109116,-0.00412993598729372,-0.113246209919453,0.102360159158707,0.184401303529739,-0.030696602538228,-0.019819937646389,0.224367797374725,-0.0061148963868618,0.0684718191623688,0.0555245541036129,-0.0324945487082005,0.00130299851298332,-0.00511670671403408,-0.127895787358284,0.01016915589571,0.13160939514637,-0.111353568732738,-0.0311722066253424,0.00372699275612831,-0.141589999198914,0.0481137335300446,-0.0317297540605068,0.0080631747841835,-0.00106312241405249,-0.0138523196801543,-0.18743209540844,0.0305165685713291,0.189383894205093,-0.238493666052818,0.195571020245552,0.17558628320694,0.0133741619065404,0.127645686268806,0.0772313624620438,0.0193594396114349,0.0212249159812927,-0.125648394227028,-0.156481698155403,-0.0290895663201809,0.0913827419281006,0.0337834134697914,0.0298458747565746,0.0147692291066051};
        Cofre cofre = new Cofre(this.autorizados, 0.1, 2);

        // act
        boolean resultado = cofre.abrir(login, perfil, senha, biometria, geolocalizacao);
    }

    @Test(expected = GeolocalizacaoComFormatoIncorretoException.class)
    public void deveLancarExcecaoDeGeolocalizacaoComFormatoIncorretoQuandoFaltaremValoresNaGeolocalizacao() throws NoSuchAlgorithmException, BiometriaComFormatoIncorretoException, GeolocalizacaoComFormatoIncorretoException {
        String login = "victor.damke";
        String senha = "SenhaDoVictor";
        Perfil perfil = Perfil.INSTRUTOR;
        double[] geolocalizacao = {-51.127550};
        double[] biometria = {-0.0717240795493126,0.200424239039421,0.0795498192310333,-0.0251115821301937,-0.0814622119069099,0.029400322586298,-0.0213277991861105,-0.121166698634624,0.137610971927643,-0.121532410383224,0.219820812344551,0.0326585657894611,-0.202189430594444,0.0765653625130653,0.00401705782860518,0.0909221544861794,-0.140626832842827,-0.0937680155038834,-0.15438623726368,-0.12654148042202,0.0755802318453789,0.0510320290923119,-0.0419369973242283,0.115638792514801,-0.185452610254288,-0.213810309767723,-0.0835670977830887,-0.0531335696578026,0.194502651691437,-0.0575171895325184,-0.0845270082354546,-0.0414815619587898,-0.185585513710976,-0.00712401419878006,-0.00706483703106642,-0.0405994169414043,-0.0177285149693489,-0.118289694190025,0.197652652859688,0.00473394803702831,-0.124115504324436,0.0695038661360741,0.0517630875110626,0.247236296534538,0.182528674602509,0.0120388949289918,0.0902915671467781,-0.0855348259210587,0.137425035238266,-0.24683965742588,0.070648729801178,0.135296046733856,0.128352895379066,0.13893735408783,0.0129938125610352,-0.260438621044159,0.0118288304656744,0.151524245738983,-0.209388762712479,0.184834316372871,0.0698952227830887,-0.123996213078499,-0.028987143188715,-0.0314105451107025,0.124371588230133,0.089169517159462,-0.102745182812214,-0.176323086023331,0.0989512652158737,-0.208186864852905,0.0151518899947405,0.102145493030548,-0.0984270945191383,-0.202222555875778,-0.251518040895462,0.113038398325443,0.406335115432739,0.292576491832733,-0.160103693604469,0.0283763613551855,-0.0628431364893913,-0.0207597371190786,0.0996167063713074,0.0557213723659515,-0.0873976349830627,-0.107157692313194,-0.0916686803102493,0.117477178573608,0.244352534413338,0.00656623207032681,0.0039253318682313,0.296879529953003,0.0599085837602615,-0.031019264832139,-0.0594459995627403,0.102026894688606,-0.189244881272316,-0.0255255550146103,-0.0100112166255713,0.0563904717564583,-0.0312739089131355,-0.0449331514537334,0.0229957215487957,0.0882981270551682,-0.218520402908325,0.209871992468834,-0.047384861856699,-0.0291850529611111,-0.0479375459253788,-0.0050220899283886,-0.115637965500355,-0.0140184136107564,0.149251565337181,-0.245322212576866,0.15214766561985,0.222329303622246,0.0643958821892738,0.158732324838638,0.0528756827116013,0.0589691326022148,0.0725817978382111,-0.0196244567632675,-0.140394330024719,-0.0864106267690659,0.0804716646671295,-0.130521312355995,0.0442943871021271,0.0199476405978203};
        Cofre cofre = new Cofre(this.autorizados, 0.1, 2);

        // act
        boolean resultado = cofre.abrir(login, perfil, senha, biometria, geolocalizacao);
    }

    @Test(expected = GeolocalizacaoComFormatoIncorretoException.class)
    public void deveLancarExcecaoDeGeolocalizacaoComFormatoIncorretoQuandoSobraremValoresNaGeolocalizacao() throws NoSuchAlgorithmException, BiometriaComFormatoIncorretoException, GeolocalizacaoComFormatoIncorretoException {
        String login = "victor.damke";
        String senha = "SenhaDoVictor";
        Perfil perfil = Perfil.INSTRUTOR;
        double[] geolocalizacao = {-29.686930, -51.127550, -51.127550};
        double[] biometria = {-0.0717240795493126,0.200424239039421,0.0795498192310333,-0.0251115821301937,-0.0814622119069099,0.029400322586298,-0.0213277991861105,-0.121166698634624,0.137610971927643,-0.121532410383224,0.219820812344551,0.0326585657894611,-0.202189430594444,0.0765653625130653,0.00401705782860518,0.0909221544861794,-0.140626832842827,-0.0937680155038834,-0.15438623726368,-0.12654148042202,0.0755802318453789,0.0510320290923119,-0.0419369973242283,0.115638792514801,-0.185452610254288,-0.213810309767723,-0.0835670977830887,-0.0531335696578026,0.194502651691437,-0.0575171895325184,-0.0845270082354546,-0.0414815619587898,-0.185585513710976,-0.00712401419878006,-0.00706483703106642,-0.0405994169414043,-0.0177285149693489,-0.118289694190025,0.197652652859688,0.00473394803702831,-0.124115504324436,0.0695038661360741,0.0517630875110626,0.247236296534538,0.182528674602509,0.0120388949289918,0.0902915671467781,-0.0855348259210587,0.137425035238266,-0.24683965742588,0.070648729801178,0.135296046733856,0.128352895379066,0.13893735408783,0.0129938125610352,-0.260438621044159,0.0118288304656744,0.151524245738983,-0.209388762712479,0.184834316372871,0.0698952227830887,-0.123996213078499,-0.028987143188715,-0.0314105451107025,0.124371588230133,0.089169517159462,-0.102745182812214,-0.176323086023331,0.0989512652158737,-0.208186864852905,0.0151518899947405,0.102145493030548,-0.0984270945191383,-0.202222555875778,-0.251518040895462,0.113038398325443,0.406335115432739,0.292576491832733,-0.160103693604469,0.0283763613551855,-0.0628431364893913,-0.0207597371190786,0.0996167063713074,0.0557213723659515,-0.0873976349830627,-0.107157692313194,-0.0916686803102493,0.117477178573608,0.244352534413338,0.00656623207032681,0.0039253318682313,0.296879529953003,0.0599085837602615,-0.031019264832139,-0.0594459995627403,0.102026894688606,-0.189244881272316,-0.0255255550146103,-0.0100112166255713,0.0563904717564583,-0.0312739089131355,-0.0449331514537334,0.0229957215487957,0.0882981270551682,-0.218520402908325,0.209871992468834,-0.047384861856699,-0.0291850529611111,-0.0479375459253788,-0.0050220899283886,-0.115637965500355,-0.0140184136107564,0.149251565337181,-0.245322212576866,0.15214766561985,0.222329303622246,0.0643958821892738,0.158732324838638,0.0528756827116013,0.0589691326022148,0.0725817978382111,-0.0196244567632675,-0.140394330024719,-0.0864106267690659,0.0804716646671295,-0.130521312355995,0.0442943871021271,0.0199476405978203};
        Cofre cofre = new Cofre(this.autorizados, 0.1, 2);

        // act
        boolean resultado = cofre.abrir(login, perfil, senha, biometria, geolocalizacao);
    }

}
