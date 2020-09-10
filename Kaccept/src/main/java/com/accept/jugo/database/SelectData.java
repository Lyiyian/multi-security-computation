package com.accept.jugo.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.json.JSON;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import java.util.ArrayList;

public class SelectData {


    public static List<String> selectdatabase(String sql, String databasename) {


        Connection connection = null;
        Statement statement = null;
        List<String> selectdata = new ArrayList<String>(); //???????????

        try {
            String url = "jdbc:postgresql://202.114.114.46:5432/" + databasename;
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, "postgres", "webgis327");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();

            //int subposition=6;


            while (resultSet.next()) {
                String lat=resultSet.getString(1);
                String lng=resultSet.getString(2);
                selectdata.add(lat+"-"+lng);

                //array.put(jsonObj);
            }

            //selectdata value{(115684,191715),(117901,186706),(115233,185313),(116702,186543),(115558,192925),(117645,184722),(114983,192015),(116153,186000),(114878,190113),(115894,191479),(118491,185324),(115172,189178),(119179,184403),(116298,189954),(115982,188931),(113662,190337),(120215,183838),(115263,190273),(117962,184403),(114638,189977),(117097,188738),(116382,186124),(115768,190167),(116567,190807),(114247,191616),(115869,190025),(113478,192296),(119077,185818),(116213,183858),(114989,189463),(117774,184965),(115645,189755),(115596,186852),(117598,184105),(116043,191103),(116981,191046),(114440,189920),(119357,185288),(114509,191355),(114251,190581),(118316,187179),(116550,190813),(114871,188957),(115230,185196),(115809,187768),(115142,186378),(116972,193242),(114706,189433),(116937,189157),(118057,181827),(117476,190902),(117211,186087),(117330,191263),(118321,184228),(115270,191240),(117247,188400),(114963,189580),(115667,193688),(113311,191525),(117944,188342),(115763,189724),(119252,185482),(113653,189521),(115761,189989),(115293,191041),(114904,189032),(113971,186221),(117205,186291),(117394,183176),(117950,185535),(115949,186125),(114616,190705),(116996,188428),(115013,188613),(116699,186891),(114681,190108),(116368,192926),(117588,186903),(117276,182858),(117640,189961),(114137,191080),(116760,183098),(116040,191350),(118960,185815),(115544,186390),(115414,188561),(114366,192017),(115582,188498),(116025,186983),(116009,187408),(115913,187435),(117816,187257),(113896,190233),(117543,188043),(117901,187392),(118270,186119),(115615,187372),(115948,186185),(116829,182847),(118000,186328),(115100,185386),(115199,190128),(113933,190593),(115338,188886),(117971,183140),(113889,190426),(115060,186898),(115687,191087),(115445,188636),(113521,192892),(117997,186434),(115152,188410),(113422,192883),(115008,189972),(114819,190063),(115184,192583),(117718,185262),(117735,183068),(112945,191518),(116513,194541),(116909,182752),(117547,187381),(114814,190811),(119590,185216),(115964,194526),(116033,189696),(115165,192718),(117563,187675),(117725,184298),(117428,188705),(117902,183825),(117392,184371),(117096,185414),(112737,193656),(115635,187746),(114422,189958),(116622,190477),(116845,187343),(115620,189485),(117849,187018),(116139,191277),(115968,191324),(116413,186204),(117224,185610),(115332,189079),(114823,185371),(115621,194365),(115635,185589),(117909,186434),(119387,185416),(119387,185422),(119708,184036),(114572,185372),(117500,185246),(113780,190708),(117593,190809),(116918,190620),(115382,192905),(118097,185172),(115448,193271),(117533,190789),(114179,189743),(116657,190117),(114503,190024),(113880,190408),(117894,187656),(113712,190103),(115606,186516),(115699,186774),(114870,188986),(114981,190415),(116166,194928),(117168,182977),(115539,189984),(116411,186270),(115025,189574),(116532,194260),(117582,186319),(115130,189365),(115520,191933),(116086,189996),(117636,190052),(114355,190437),(115090,185780),(117677,190179),(115868,188987),(117018,191350),(114225,190360),(118068,184673),(115022,189972),(114577,185208),(117878,182739),(114144,190899),(116808,193736),(114170,190007),(115192,190463),(115562,189937),(113693,190196),(116896,184292),(115337,184896),(116433,190929),(118802,186079),(115526,185204),(114361,191685),(113971,186221),(115522,193002),(114826,189353),(116071,188909),(113661,189939),(113877,189411),(115789,190786),(115510,189788),(115738,187797),(113671,190159),(117063,191087),(117633,190164),(115400,189030),(116792,186864),(114971,188641),(113628,191002),(117676,190450),(115184,192061),(118247,186340),(118707,184525),(117047,191078),(114255,189954),(115198,190642),(117078,186089),(117529,183041),(115146,188611),(117135,190964),(114510,189819),(116122,187109),(117998,186382),(120027,183526),(117621,189562),(118081,185788),(117757,188887),(116623,186425),(117587,185706),(113720,191469),(113777,191537),(114946,190886),(119451,185489),(115169,188646),(118367,187572),(114522,187023),(116946,185443),(117512,185521),(113979,191542),(116365,195066),(117423,183305),(117993,184182),(116822,191645),(113745,190264),(117609,182584),(114955,189705),(115682,191430),(115772,194304),(114226,190314),(114246,190352),(113683,190639),(117841,189162),(113737,190370),(116962,185484),(113735,190302),(117183,186573),(119070,186071),(115079,186231),(115245,191451),(115364,191665),(116799,188423),(112792,191956),(113326,191812),(115370,190025),(114233,190115),(116787,189526),(115152,188406),(115314,188556),(116887,192723),(116958,191162),(118027,185238),(113909,189833),(117143,186145),(117994,184906),(118801,184593),(115854,190085),(119690,184760),(116148,190064),(114413,189889),(116953,192143),(115308,193169),(115389,191065),(116858,192372),(118750,185573),(116225,191105),(118004,186183),(119074,185931),(114441,189884),(119960,184956),(116968,185284),(117836,185904),(118279,185782),(116683,186012),(117180,186012),(114420,190496),(117046,191843),(118504,185084),(117381,184769),(118048,183392),(114104,189991),(117186,185760),(116157,185864),(113823,191765),(116782,186014),(117459,184357),(117791,190424),(116732,184220),(119345,185796),(117072,189272),(115594,186922),(116275,189986),(116096,190411),(116641,190216),(117538,182103),(115840,194239),(115784,194202),(115272,193661),(115262,190333),(115581,190517),(117219,185761),(115028,188902),(114568,191593),(117761,190695),(116094,186929),(116940,186284),(115293,191349),(114681,189929),(115734,186699),(117830,187693),(115085,190014),(116016,189994),(114977,187432),(116532,194260),(115405,192109),(114191,190376),(118301,184977),(115533,186099),(116530,195030),(114464,190179),(116808,187027),(116718,187141),(114441,189884),(114496,193350),(119070,186061),(113688,190226),(115102,189076),(117041,182764),(114380,187330),(117797,184178),(118667,186383),(114981,189722),(116942,187097),(113810,190824),(115488,189983),(116683,186012),(116097,187543),(114789,184834),(116497,195031),(115028,191666),(117929,182575),(115530,186845),(119143,185864),(117800,185564),(116406,186022),(117582,186319),(116867,189094),(119106,185729),(115708,187577),(115340,187884),(116675,186277),(117742,186081),(115623,188922),(114298,191816),(113688,191535),(114017,192985),(117621,188312),(118310,187438),(117588,186903),(119589,185277),(119506,184551),(118805,185781),(116844,190067),(116646,187338),(116037,193116),(117306,182809),(113913,192094),(117205,186287),(117787,186857),(114459,191487),(118295,187501),(114708,189167),(118766,184657),(116298,191200),(115352,193129),(115313,192179),(114973,191254),(117650,189590),(115601,192600),(118130,188166),(116103,190170),(118001,186297),(115460,191045),(118154,185513),(115704,186203),(118016,188177),(115754,190630),(117698,187682),(115317,193187),(117329,182102),(118339,184548),(118197,187135),(114421,190462),(115445,188631),(114957,190533),(115811,185108),(119302,183778),(113063,190989),(115709,191050),(116389,186285),(117317,184385),(117846,187108),(115152,190668),(115698,193475),(117279,189820),(115701,189556),(116979,184177),(119623,184434),(116209,189841),(114540,190138),(117874,186661),(117538,185410),(116870,192163),(116931,190162),(116174,185252),(115798,186775),(117347,188406),(116659,191574),(117775,186501),(116091,189864),(115098,191469),(114071,190748),(118834,185142),(115648,185737),(115619,186047),(119083,185567),(117496,188707),(117681,189507),(117923,185922),(114672,189864),(115976,192273),(118004,186172),(116811,185766),(117472,190086),(114995,189282),(115028,188902),(115020,192087),(116479,190973),(115806,186522),(114171,189974),(117589,190808),(112834,191003),(115552,188372),(117949,186578),(119453,185423),(113950,192994),(113686,189515),(116726,186295),(116889,192656),(114880,189901),(115297,191774),(116577,186195),(115351,191775),(118805,185747),(113276,192216),(114410,190977),(119111,186095),(117812,186763),(114948,190813),(115157,191803),(117665,185698),(118572,186331),(115234,191339),(116871,185203),(115028,189475),(118419,185532),(113618,193256),(117007,190096),(115643,194589),(116120,189535),(115126,189493),(115952,193094),(115722,191583),(114949,191566),(119844,184638),(117017,188322),(119072,186011),(117757,183666),(117924,185887),(116685,194423),(114488,192885),(115158,185024),(115338,188886),(115062,186833),(118569,186451),(119074,185931),(117507,188639),(117646,190420),(114071,189983),(115494,192858),(115628,192800),(116962,185483),(114815,186777),(114877,189933),(117594,185573),(116012,186262),(118243,183672),(118027,185254),(114849,188548),(117211,186061),(117482,185884),(114954,189970),(117853,185797),(115118,189444),(115146,192369),(116975,189401),(114576,191024),(116251,190798),(113967,189779),(116485,190748),(115257,191931),(116725,182578),(117797,187306),(117974,185649),(117446,188409),(116043,187522),(119634,185556),(118393,187780),(117688,188279),(115141,184701),(117694,185926),(115194,186899),(117169,184026),(116689,185793),(116472,193468),(117680,182439),(115574,188758),(116501,193679),(114331,190353),(117590,190836),(113325,191822),(117777,184236),(117466,182977),(116762,184350),(116271,191310),(115364,191668),(117928,188569),(117640,189961),(118729,185489),(119070,186078),(115982,189993),(114658,190060),(116947,192108),(117662,183100),(115759,192015),(116944,192108),(119390,185296),(116052,188073),(114915,189439),(119077,185818),(118436,187453),(116314,189040),(115399,189715),(116593,186862),(117987,186806),(116945,192108),(117241,187392),(116614,184870),(114886,190065),(113620,190546),(114155,190465),(113920,190201),(114974,188372),(115113,185722),(117290,185620),(114470,191400),(120161,183933),(115759,189724),(116080,190062),(116583,190708),(117674,182633),(117664,184104),(116278,189847),(115187,190606),(114606,191025),(115235,186555),(117227,186839),(119492,185147),(117455,184484),(119690,184752),(115473,191977),(116142,190064),(115075,190373),(115649,183598),(114863,189217),(116695,186798),(114892,189803),(115623,191807),(116778,183111),(115323,191374),(119564,185547),(117498,188441),(116826,188559),(117607,185922),(115610,188686),(114561,191786),(115078,186247),(116306,190051),(116490,190407),(115182,189667),(118902,185075),(114880,191048),(119018,184216),(115980,187399),(115345,185063),(116866,193072),(117257,185760),(117498,188441),(117300,185689),(115429,188851),(115824,189725),(116670,187289),(117231,186558),(118513,185715),(116745,193145),(114033,189847),(115269,193720),(117454,182299),(114862,188904),(118196,186388),(115004,188931),(115510,189779),(115122,186784),(114007,186222),(115670,194234),(116962,185481),(116081,191855),(115184,192070),(114763,189214),(114061,191411),(117731,186485),(116883,189485),(115814,184978),(116750,182615),(118162,187994),(113754,190498),(119064,184235),(118841,184345),(117900,182533),(117508,188588),(112856,191517),(117525,188496),(115641,185200),(115642,185165),(113980,190513),(115930,186542),(117623,188095),(118063,186517),(116856,192965),(117565,184109),(117633,190134),(119152,185833),(114276,190051),(116062,191506),(117010,192311),(115722,190055),(116755,189482),(115068,192234),(114821,193109),(118324,181842),(115064,186771),(118349,186256),(115943,190060),(115489,190527),(115399,189715),(114974,189926),(117065,186553),(115853,191318),(113820,191888),(116242,184007),(118835,187113),(113879,191024),(115402,190313),(117632,190743),(115256,191065),(118843,185278),(115142,191198),(114927,190770),(119279,184098),(118352,185583),(117659,183332),(119119,184153),(118963,185295),(115631,188658),(115942,187578),(116031,183624),(116942,186210),(114844,191134),(116118,186065),(116920,189157),(114787,188398),(117516,189550),(115195,185634),(118386,186967),(115443,190447),(116023,185863),(114431,191021),(116773,192117),(115904,191220),(116624,186425),(118294,185196),(117934,185501),(116817,184747),(114222,192346),(115944,193352),(116088,194926),(114875,188790),(116187,191271),(116286,189954),(117069,190144),(116641,193805),(117605,183331),(117049,191772),(118305,184856),(117070,192582),(117071,186354),(115832,189765),(114037,190680),(115996,191595),(117763,185321),(117822,183128),(119271,185899),(116588,194262),(115635,190110),(117607,183771),(115293,191041),(117859,182640),(118237,185610),(114572,185372),(113728,189930),(116940,186282),(119591,184648),(117633,189898),(115233,190185),(117052,188238),(117617,185826),(115258,191373),(115359,191242),(114344,190256),(117505,183793),(114462,191679),(113770,193416),(119629,185437),(119731,185043),(116544,191554),(117078,190834),(117269,185165),(113772,190973),(114252,191923),(118004,186183),(117567,182912),(115314,188556),(115100,189509),(114980,191566),(114957,189738),(117778,182443),(115846,186252),(118956,185335),(116712,184951),(117804,182649),(117982,185320),(115337,184896),(115719,189493),(115407,191021),(116218,190066),(116283,190035),(119801,185317),(117010,183117),(114174,190483),(118321,184228),(113776,191005),(118011,185919),(118022,184322),(116817,193956),(114238,191814),(116000,190591),(119867,185253),(118516,186858),(118747,185670),(115488,191864),(117907,186495),(118230,186323),(116555,187057),(117035,192172),(115016,192965),(115950,186115),(119006,186204),(118119,185590),(113849,190631),(115923,191254),(115276,185161),(119371,185752),(116328,186284),(116122,189490),(117225,189756),(116917,192343),(113256,193305),(116507,191168),(118329,185194),(118318,185590),(117347,189921),(118389,184748),(116725,193864),(115013,188614),(114440,189906),(117216,185889),(116108,186082),(114926,189356),(120151,183577),(116885,188317),(115109,186551),(115415,193261),(114923,190114),(116821,190635),(116867,186415),(116689,187007),(118617,186251),(116679,186125),(116968,186475),(114355,190461),(116155,194060),(113834,191440),(113878,190752),(116734,186229),(116780,182637),(116756,191607),(115549,191779),(117073,186288),(116246,191462),(116234,191130),(115534,188979),(117896,183662),(117573,187383),(112244,192031),(115111,192899),(115318,191508),(115520,191254),(117664,190129),(114408,189922),(117080,186023),(115787,189451),(116691,185744),(115093,189476),(118026,185304),(114966,188729),(114924,190114),(118037,184206),(114168,190063),(116811,193536),(114608,191824),(117830,182074),(114300,191916),(117730,183666),(115056,188643),(114968,190128),(116128,187427),(118832,185557),(115783,186117),(115184,186653),(112956,191385),(116145,186264),(117019,185812),(117521,187380),(115970,190136),(118216,181921),(117561,188975),(113785,190567),(118104,185207),(117356,191380),(115398,190322),(116879,184886),(117105,185094),(116120,186281),(114378,191486),(116979,189357),(117070,185160),(115334,188915),(116262,191073),(118817,186966),(113143,192290),(114978,190919),(116755,185796),(118925,185758),(116887,186697),(117751,185781),(114735,191444),(117124,189377),(115839,190588),(115404,191670),(116106,189769),(115881,190948),(117662,184178),(117112,189803),(116413,186204),(114160,190025),(119564,184448),(113964,189878),(119190,185828),(115279,191573),(119345,185796),(117802,187094),(116940,186276),(115375,193033),(118854,185939),(112043,192554),(118017,188101),(117562,190081),(114461,190389),(117172,192046),(116695,186798),(118808,185645),(117499,188601),(118511,186248),(118321,186276),(115969,192525),(117892,182764),(115444,191844),(115955,191381),(117492,183175),(115005,188903),(115000,188675),(115889,190631),(114094,190285),(118093,185312),(118617,186247),(115211,190642),(116020,189596),(117330,190907),(118429,185482),(116685,185945),(118436,187456),(117754,189007),(115140,188821),(114614,191049),(115146,188614),(114919,191298),(116047,189778),(115044,190938),(114105,189807),(117279,189820),(115753,189489),(115707,188823),(116665,192427),(115990,185856),(116162,185668),(115494,190345),(117946,181666),(118440,186395),(115805,193518),(114429,192617),(114173,190483),(117689,185261),(118636,185474),(114821,187078),(115429,194754),(117987,185602),(120359,183528),(116873,183114),(114225,191016),(117183,187121),(115209,188755),(117542,186983),(117881,183450),(114162,189718),(115429,192361),(115458,190780),(115890,192942),(114112,190858),(115634,189853),(116164,186995),(114967,189614),(113613,191094),(119728,184759),(115404,191672),(115244,191481),(115335,191422),(117954,186446),(116072,186512),(115283,185128),(115085,185393),(117826,187836),(117826,182996),(114581,192441),(117748,184728),(117199,184715),(115293,191350),(115324,191918),(114037,191377),(119689,185229),(118401,181839),(117609,183721),(118361,184465),(116182,192008),(119079,184408),(116875,182760),(118460,185252),(118802,186106),(117704,188184),(117075,185010),(113868,191007),(115270,191886),(118835,187112),(118471,185217),(115184,192370),(114966,188732),(117735,184263),(117802,183402),(116350,187265),(115003,188984),(117475,187362),(117164,185361),(117500,188949),(117150,187368),(117152,190730),(115024,189419),(116754,194133),(116221,183610),(117115,185946),(113309,192211),(115456,189422),(116858,186564),(114335,191454),(115603,187396),(114164,190184),(117333,189397),(115194,186892),(117594,190019),(116195,188936),(117749,189187),(118244,187161),(116347,189738),(116312,194743),(115744,189458),(119944,181590),(117569,189535),(114549,189795),(116450,187268),(114510,189819),(113969,190343),(114957,190521),(117636,190050),(114467,190489),(116944,193016),(116373,187384)}
            System.out.println("select result" + selectdata);
        } catch (Exception e) {
            System.out.println("error" + e);
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error" + e);
                throw new RuntimeException(e);
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("error" + e);
                    throw new RuntimeException(e);
                }
            }
        }
        return selectdata;
    }

}