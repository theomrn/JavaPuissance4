Exercice 3.1 — Ges.on de la grille
On va en premier lieu déterminer la gesQon de la grille en tant que structure de données et
comment simuler l’état de chaque case (vide, jeton rouge ou jeton jaune). Faute de beaucoup
de connaissances en Java et en POO pour le moment, nous allons rester sur un encodage
simple.
1. Créez trois constantes de type int en dehors de la foncQon main. C’est une première
pour vous mais pas de panique : il suﬃt juste d’ajouter le mot clé static avant le mot
clé final. Ces trois constantes sont :
• VIDE = 0
• ROUGE = 1
• JAUNE = 2
2. Créez une foncQon nouvelleGrille (int largeur, int hauteur) qui
renvoie un nouveau tableau en deux dimensions de taille largeur et hauteur. Ce
tableau doit être uniquement consQtué de VIDE. Je vous laisse choisir quelle
dimension représente l’horizontale, et quelle dimension la verQcale
Exercice 3.2 — Aﬃchage de la grille
Maintenant que nous avons conceptualisé la grille, il va nous falloir l’aﬃcher.
1. Créez une nouvelle foncQon afficheGrille (int [] [] grille). Vous devrez
pour cela uQliser deux boucles for ainsi qu’un branchement condiQonnel de votre
choix. CeEe foncQon doit, avec seulement la grille et les trois constantes de l’exercice
1, vous aﬃcher une grille comme l’exemple ici :
2. Testez votre aﬃchage en aﬀectant manuellement quelques jetons à votre grille dans
la foncQon main.
Exercice 3.3 — Grille gagnante
Il est important de savoir à tout moment si un des deux joueurs a gagné : il faut aligner 4 jetons
de la même couleur, que ce soit horizontalement, verQcalement ou en diagonale.
Créez la foncQon grilleGagnante (int [] [] grille) qui vérifie si une grille est
gagnante ou non. Elle renvoie un booléen qui indique si oui ou non la grille est gagnante. Vous
devrez faire pas mal de boucles for, c’est normal. Il existe des algorithmes plus performants
mais qui sortent du cadre du cours.
Exercice 3.4 — Tour d’un joueur
Durant une parQe de Puissance 4, les deux adversaires vont s’aﬀronter au tour par tour. Pour
faire les choses bien, nous allons donc créer une foncQon qui simule un tour de jeu d’un des
deux joueurs.
1. Écrivez la foncQon joueJeton (int [] [] grille, int colonne, int
couleur) qui simule un jeton joué dans une des colonnes de la grille. Vous devez
prendre en compte la gravité.
2. Concevez ensuite la foncQon tourJoueur(Scanner scanner, int [] []
grille, String nomJoueur, int couleur) qui eﬀectue le tour de jeu du
joueur nomJoueur. Elle renvoie un booléen. Le tour se déroule comme suit :
a. Demander au joueur dans quelle colonne il souhaite placer son jeton
b. Si la colonne est pleine, lui signaler et recommencer
c. Sinon, jouer le jeton
d. Aﬃcher la grille en l’état actuel
e. Vérifier si la grille est gagnante. Si c’est le cas, renvoyer true.
f. Sinon renvoyer false.
Exercice 3.5 — Puissance 4
UQlisez toutes les foncQons que vous venez de coder, et écrivez dans main le code permeEant
de simuler une parQe de Puissance 4 sur une grille de 7 par 6.
