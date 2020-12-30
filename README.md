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
  - Coroutines
  - Appel Webservice à une API Rest
  - Clean Architecture
  - Architecture MVVM
  - Design :
            - Images
            - Animations
            - Research bar
         
### Ressources et liens

  - Github
  - API
  
Lien vers API Documentation : https://www.coinlore.com/cryptocurrency-data-api (CoinLore
API utilisée : 
  - https://api.coinlore.net/api/tickers/ (affichée dans la Recyclerview)


L'application s'ouvre avec un écran (Splash) avec une animation. Après 3 secondes, on affiche un écran de login avec 2 champs (Login et Password) et 2 boutons (Login et Create Account).
En appuyant sur Login, on affiche une liste de type Recyclerview qui permet à l'utilisateur de voir (grâce à un appel API) à l'écran des cryptomonnaies avec leur nom et leur Ticker (symbole en finance pour l'identification).
En appuyant sur une des cryptomonnaies de la liste, l'utilisateur accède à un autre écran qui lui permet de voir les détails de cette dernière (symbole, nom, rang et prix en US dollar).
Lorsque l'application est fermée, l'utilisteur reçoit quotidiennement une notification Push grâce au Cloud Messaging FireBase. Le message l'invite à acheter des actions :D .

### Ecran animé (Splash)
La première activité montre un écran d'accueil Splash avec une animation qui fait apparaître le nom de l'application. 

![alt_text](https://github.com/FilippoEsiea/FinanceHUB/blob/master/%C3%A9cran3d.PNG)


### Login (champs texte + boutons)
La deuxième activité est un écran de Login.
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/login.PNG)
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/loginError1.PNG)


### RecyclerView + Appel API Rest
La troisième activité
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/recyclerView.PNG)
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/recyclerViewFilter.PNG)
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/recyclerViewSearch.PNG)


### Détail élément
On peut observer le détail avec symbole, nom, rang, et prix en US dollar
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/detail.PNG)
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/detail2.PNG)

### Ecran Création de compte
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/createAccount.PNG)
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/createAccountCreated.PNG)
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/createAccountError1.PNG)
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/createAccountError2.PNG)

### Animation
![alt_text](https://github.com/FilippoEsiea/AndroidKotlin2/blob/master/bloggif_5fecaf56e58e3.gif)
