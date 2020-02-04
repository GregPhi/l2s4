set title 'Analyse des filtres de Bloom'
set xlabel 'Taille du filtre'
set ylabel 'Pourcentage de faux positifs'
set term png
set output 'tp4_hash1.png'
plot 'res.txt' index 0 using 1:($5*100) w lp t '#hash 1'


set title 'Analyse des filtres de Bloom'
set xlabel 'Taille du filtre'
set ylabel 'Pourcentage de faux positifs'
set term png
set output 'tp4_hash2.png'
plot 'res.txt' index 1 using 1:($5*100) w lp t '#hash 2'


set title 'Analyse des filtres de Bloom'
set xlabel 'Taille du filtre'
set ylabel 'Pourcentage de faux positifs'
set term png
set output 'tp4_hash3.png'
plot 'res.txt' index 2 using 1:($5*100) w lp t '#hash 3'

set title 'Analyse des filtres de Bloom'
set xlabel 'Taille du filtre'
set ylabel 'Pourcentage de faux positifs'
set term png
set output 'tp4_hash4.png'
plot 'res.txt' index 3 using 1:($5*100) w lp t '#hash 4'


set title 'Analyse des filtres de Bloom'
set xlabel 'Taille du filtre'
set ylabel 'Pourcentage de faux positifs'
set term png
set output 'tp4_hash5.png'
plot 'res.txt' index 4 using 1:($5*100) w lp t '#hash 5'


set title 'Analyse des filtres de Bloom'
set xlabel 'Taille du filtre'
set ylabel 'Pourcentage de faux positifs'
set term png
set output 'tp4_hash6.png'
plot 'res.txt' index 5 using 1:($5*100) w lp t '#hash 6'


set title 'Analyse des filtres de Bloom'
set xlabel 'Taille du filtre'
set ylabel 'Pourcentage de faux positifs'
set term png
set output 'tp4_hash7.png'
plot 'res.txt' index 6 using 1:($5*100) w lp t '#hash 7'


set title 'Analyse des filtres de Bloom'
set xlabel 'Taille du filtre'
set ylabel 'Pourcentage de faux positifs'
set term png
set output 'tp4_hash8.png'
plot 'res.txt' index 7 using 1:($5*100) w lp t '#hash 8'
