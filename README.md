# Chefies Mobile
An application that is integrated with **machine learning** to help users get recommendations for food menus that can be cooked from the food ingredients they have at that time.

## 👍 Basic Information
- Language: **Kotlin**
- Operating System: **Android**

## 👥 Mobile Development Team
- Frans Budi Kashira ([Link](https://github.com/Frans-Budi))
- Rhehan Muzaky ([Link](https://github.com/rhehan7))

## 🎨 Prototype
[Prototype - Figma](https://www.figma.com/design/NNFJNwEGcXdVKdgLMWDids/Chefies?node-id=0-1)

## 🛠️ Tools
- Code Editor: **Android Studio**
- Testing API: **Postman**
- Repository: **GitHub**

## 🔑 Features
- Authentication
  - Login
  - Register
  - Logout
  - Auto login
- Customize
  - Change profile
  - Change password
  - Change Theme to Dark Mode
  - Change Language
- Classify Image With AI (on-device)
- Integration with API
- Save suggestion to Local Database (Room)
- Media
  - Take picture from camera
  - Take picture from gallery

## ⌛️ Development Process
- Design UI for Application (Figma)
- Slicing IU from figma to codes (XML)
- Build the business logic and the architecture 
- Integration with AI from machine learning team
- Integration with API from cloude computing team 
- Developing features 
- Testing application

## 💻 Tech Stack
- MVVM (Model-View-ViewModel) Architecture Pattern
- Coroutines Flow
- ViewBinding
- Jetpack Compose with Material3

## Getting Started Application
- ## Preparation
  - ## Tools Sofware
    This is build with Android Studio Jelly Fish, you can use any other version but if any crash or error you can use the latest version of android studio.
    - [Android Studio](https://developer.android.com/studio)
    - [Postmant](https://www.postman.com/) to test API from Cloud Computing
  - ## Requirements
    - Java Version : 18
  - ## Instalation
    - [Chefies App](https://github.com/Chefies/chefies-mobile/releases/tag/v1.0)
    - Because of free GitHub LFS limitation, we cannot store the actual file of TFLite model in this repository. If you got any error when cloning from this repository, paste the model from [Model Machine Learning](https://github.com/Chefies/chefies-machine-learning/releases/tag/v1.0) to 'app/src/main/ml' as 'ingredient_classification.tflite'
