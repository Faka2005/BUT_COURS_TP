# R4.11 TD 2 : Gestion des événements & état


## Objectifs

- gestion des événements
- découverte du `ViewModel`


## 1. Premiers pas

Nous allons reprendre le formulaire de contact du TP précédent

* décompactez le fichier fourni et ouvrez le dossier obtenu depuis Android Studio.
* en utilisant des composants à état, rendez l'interface vivante 


## 2. Convertisseur de température


### Première version
Complétez le code fourni pour que votre convertisseur de température soit fonctionnel.
Conseil : ne conserver dans votre état que la température en celsius. En cas de modification de celsius, la recomposition entrainera le recalcule de la valeur en farenheit.

### Hissage d'état

Décomposez maintenant votre convertisseur en deux parties : 

1. un composant stateless paramétré (par exemple : `celsiusValue: Float`, `fahrenheitValue: Float, onCelsiusChange: (Float) -> Unit`, et `onFahrenheitChange : (Float) -> Unit`) qui ne contient pas l'état

2. un composant statefull correspondant à l'écran qui défini l'état et appelle le composant stateless.


### `ViewModel`

* Autorisez la rotation sur votre dispositif de test. 
* Démarrez votre application et modifiez les valeurs
* Effectuez une rotation 
* Vous devriez constater que votre application s'est réinitialisée.

Un changement de configuration, comme un passage du mode portrait à paysage, nécessite de redessiner toute l'interface. Ceci est réalisé en détruisant puis recréant l'activité.

### Solution

La classe `ViewModel` a été conçue pour avoir un cycle de vie différent de l'activité et votre `ViewModel` est conservé, même en cas de rotation.
Nous allons donc utiliser un `ViewModel`, comme conteneur d'état, plutôt que de laisser les états dans l'activité.


Modifications gradle : 

* dans le fichier `libs.versions.toml`, ajoutez : 

```
[versions]
lifecycleCompose = "2.10.0"  # ou utiliser lifecycleRuntimeKtx

[libraries]
# pour viewModel()
androidx-lifecycle-viewmodel-compose = { group = "androidx.lifecycle", name = "lifecycle-viewmodel-compose", version.ref = "lifecycleCompose" }

```

* Dans le fichier `build.gradle.kts` (module `:app`), ajoutez dans les  `dependencies` :


```
implementation(libs.androidx.lifecycle.viewmodel.compose)
```
 
* Définissez une sous classe `XXXViewModel` de `androidx.lifecycle.ViewModel`, par exemple `TemperatureConverterViewModel`
* Référencez dans cette classe votre `State` celsius par :
    1. un état mutable privé (préfixé par `_`)
    2. un état immuable public (de même nom)
* Définissez deux méthodes pour mettre à jour votre état (par exemple `updateCelsius`, `updateFahrenheit`)
* Dans l'appel du Composable passez le `ViewModel` (c'est ici que les modifications gradle sont nécessaires) : 
 ```
 @Composable
    fun MonScreen(leViewModel: TemperatureConverterViewModel = viewModel())
 ```
La fonction  `viewModel()` permet d'instancier le  `TemperatureConverterViewModel` ou de récupérer l'instance précédente, si cela a déjà été fait.
* Mettez à jour le reste du code pour que votre composable stateless utilise le `ViewModel`
* Testez

[https://developer.android.com/topic/libraries/architecture/viewmodel.html](https://developer.android.com/topic/libraries/architecture/viewmodel.html)


## 3. Quizz

Nous allons maintenant réaliser une application en suivant le principe MVVM, comportant :
* le **Vue-Modèle** (*ViewModel*) : classe `QuizViewModel` qui sert de conteneur d'état (état observé par la vue) et fait le lien entre les données et l'UI.
* l'état : classe `QuizUiState` qui regroupe les variables définissant l'état de notre application. 
* la **Vue** : classe `QuizScreen` qui présente l'état, se redessine si celui-ci évolue et transforme les événements en appels aux méthode du `ViewModel` pour modifier l'état
* le **modèle** : ici simplifié puisque restreint à des données en dur. Il figure dans la classe `Question` fournie.

Les classes fournies sont commentées pour vous aider. Chaque clic dans la vue entraine une modification de l'état, effectuée dans le viewModel, qui provoque une recomposition.





