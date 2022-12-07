# Funktionelle Krav

Når man starter programmet op bliver man  mødt af en welcome screen som har et login system på sig, så kan man enten load et eksisterende save ellers kan man oprette et nyt save hvor man skal vælge et hold man vil kontrollere.

Når man har valgt et save kommer man ind på en Main menu som indeholder nogle knapper ud til nogle nye screens som skal være: Historik af gamle løb, Liste af alle drivers, Liste af alle teams, Information om ens eget hold og  "Continue simulation".

Ved listen af alle drivers kan man trykke ind på en driver og så får man information omkring denne driver, det samme skal ske hvis man er inde på listen af teams hvor det bare er information omkring det team man har selected

Når man er inde på information om sit eget hold er det der, hvor man skal kunne se alt information om sit eget hold, ligesom det ved listen når man trykker ind på et hold

Når man trykker ind på "Næste løb", så skal man få en menu frem af om det er kvalifikationen som er næste gang eller om det er løbet.

Hvis det er kval så skal man kunne trykke for at komme i gang med Q1, Q2 og Q3, og man skal have et "resultat" over hvordan det er gået

Hvis det er løb så skal man kunne starte løbet og se et resultat hen ad vejen

Programmet skal kunne udregne hvor hurtigt det er en bil skal køre gennemsnitligt rundt på en circuit ud fra mange forskellige faktorer som indeholder kørerens statistikker, kørerens bils statistikker, circuit statistikker og nogle tilfældige faktorer såsom vejret, random multiplier med mere.

Programmet skal kunne udregne en chance for ulykke ud fra forskellige faktorer som indeholder kørerens hastighed, kørerens statistikker, kørerens bils statistikker, circuit statistikker med mere.

Køreren der har de bedste stats; heraf hastighed har større chance for at vinde racet som udgangspunkt. Dog kan der ved circuits med mange sving, være en kører der har bedre ‘steering’ der vinder racet. Det kan også være en af de mere langsomme biler der vinder, når der introduceres regndage ind som faktor. Disse kalkuleres matematisk med fastsatte værdier.

Programmet skal have en datakilde og derfor ønskes der at det laves med en SQL-database som har tabeller for teams, kører, biler og banerne som der køres på. Der skal være en relation imellem de forskellige tabeller sådan at de nemmere kan hænges sammen.
Derudover skal der også være nogen default data tabeller som der kan loades ind når der laves et nyt save game.
Hvert game skal også gemmes med et save-name og et id som der kan refereres til.