package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DistrictMapperTest {
    @Mock
    private Mapper.Context context;
    private DistrictMapper districtMapper;

    @Before
    public void setup() {
        this.districtMapper = new DistrictMapper();
    }

    @Test
    public void testMap() throws IOException, InterruptedException {
        // First ten lines of trees.csv
        String value = "GEOPOINT;ARRONDISSEMENT;GENRE;ESPECE;FAMILLE;ANNEE PLANTATION;HAUTEUR;CIRCONFERENCE;ADRESSE;NOM COMMUN;VARIETE;OBJECTID;NOM_EV\n" +
                "(48.857140829, 2.29533455314);7;Maclura;pomifera;Moraceae;1935;13.0;;Quai Branly, avenue de La Motte-Piquet, avenue de la Bourdonnais, avenue de Suffren;Oranger des Osages;;6;Parc du Champs de Mars\n" +
                "(48.8685686134, 2.31331809304);8;Calocedrus;decurrens;Cupressaceae;1854;20.0;195.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Cèdre à encens;;11;Jardin des Champs Elysées\n" +
                "(48.8768191638, 2.33210374339);9;Pterocarya;fraxinifolia;Juglandaceae;1862;22.0;330.0;Place d'Estienne-d'Orves;Pérocarya du Caucase;;14;Square Etienne d'Orves\n" +
                "(48.8373323894, 2.40776275516);12;Celtis;australis;Cannabaceae;1906;16.0;295.0;27, boulevard Soult;Micocoulier de Provence;;16;Avenue 27 boulevard Soult\n" +
                "(48.8341842636, 2.46130493573);12;Quercus;petraea;Fagaceae;1784;30.0;430.0;route ronde des Minimes;Chêne rouvre;;19;Bois de Vincennes (lac des minimes)\n" +
                "(48.8325900983, 2.41116455985);12;Platanus;x acerifolia;Platanaceae;1860;45.0;405.0;Ile de Bercy;Platane commun;;21;Bois de Vincennes (Ile de Bercy)\n" +
                "(48.8226749117, 2.33869560229);14;Platanus;x acerifolia;Platanaceae;1840;40.0;580.0;Bd Jourdan, avenue Reille, rue Gazan, rue de la Cité‚-Universitaire, rue Nansouty;Platane commun;;26;Parc Montsouris\n" +
                "(48.8428118006, 2.2972574926);15;Alnus;glutinosa;Betulaceae;1933;16.0;220.0;Rue Th‚ophraste-Renaudot, rue L‚on-Lhermitte, rue Jean Formig‚, rue du Docteur Jacquem;Aulne glutineux;;28;Square Saint Lambert\n" +
                "(48.8717782491, 2.27973325759);16;Aesculus;hippocastanum;Sapindaceae;;30.0;505.0;Avenue Foch;Marronnier d'Inde;;30;Avenue Foch\n";
        this.districtMapper.map(null, new Text(value), this.context);
        verify(this.context, times(1))
                .write(new Text("7"), new IntWritable(1));


    }
}
