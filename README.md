# CryptoHUB

CryptoHUB est une application de cryptomonnaies déstinée à l'utilisation mobile pour avoir des informations sur les différentes cryptomonnaies en fonction de leur plateforme d'échange.

L'application a été réalisée pendant les mois de Septembre et Décembre 2020, dans le cadre du module de programmation mobile de 4ème année en __Kotlin__.

Voici le logo:

![alt text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/icone.PNG)


### Détails techniques

Langage utilisé : Kotlin

Environnement de développement : Android Studio

Outil de compilation : Gradle


## Notion abordées

  - Recyclerview + List Adapter
  - Base de données avec Room
  - Coroutines
  - Appel Webservice à une API Rest
  - Clean Architecture
  - Architecture MVVM
  - Design : Images, Animations, Research bar, Détail d'un élément
         
### Ressources et liens

  - Github
  - API
  
Lien vers API Documentation : https://www.coinlore.com/cryptocurrency-data-api (CoinLore
API utilisée : 
  - https://api.coinlore.net/api/tickers/ (affichée dans la Recyclerview)


L'application s'ouvre avec un écran (Splash) avec une animation. Après 5 secondes, on affiche un écran de login avec 2 champs (Login et Password) et 2 boutons (Login et Create Account).
En appuyant sur Login (après avoir complété les champs), on affiche une liste de type Recyclerview qui permet à l'utilisateur de voir (grâce à un appel API) à l'écran des cryptomonnaies avec leur nom et leur Ticker (symbole en finance pour l'identification).
En appuyant sur une des cryptomonnaies de la liste, l'utilisateur accède à un autre écran qui lui permet de voir les détails de cette dernière (symbole, nom, rang et prix en US dollar).
En appuyant sur Create account, l'utilisateur peut créer un compte.

Pour cette application j'ai décidé d'adopter des couleurs et thèmes sombres, afin de proposer une UI (thème dark) actuelle et appréciée de nos jours.

### Accueil (Splash)
La première activité est un écran d'accueil Splash.

<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/splash.PNG" width="300"> 


### Login (champs texte + boutons)
La deuxième activité est un écran de Login qui gère les différentes erreurs.

<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/login.PNG" width="300"> 
<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/loginError1.PNG" width="300">


### RecyclerView + Appel API Rest
La troisième activité est une liste d'éléments avec une barre de recherche.

<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/recyclerView.PNG" width="300">
<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/recyclerViewFilter.PNG" width="300">
<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/recyclerViewSearch.PNG" width="300">


### Détail élément
On peut observer le détail avec symbole, nom, rang, et prix en US dollar.

<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/detail.PNG" width="300">
<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/detail2.PNG" width="300">


### Ecran Création de compte
Voici l'écran de création de compte, avec les différentes erreurs possibles.

<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/createAccount.PNG" width="300">
<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/createAccountCreated.PNG" width="300">
<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/createAccountError1.PNG" width="300">
<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/createAccountError2.PNG" width="300">


### Animation
Voici un exemple d'animation sur l'écran d'accueil

<img src = "https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/bloggif_5fecaf56e58e3.gif" width="300">
