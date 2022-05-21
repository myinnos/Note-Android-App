# Sample Note Android App using MVVM and Room Database

Improved sample project of [How to Build a Simple Note Android App using MVVM and Room Database? by geeksforgeeks](https://www.geeksforgeeks.org/how-to-build-a-simple-note-android-app-using-mvvm-and-room-database/)

Android provides us a feature with which we can store users data inside their mobile itself with different storage options such as Shared Preferences, SQLite database, and the Room Database. All the data storing techniques are having different use cases. In this example, will see the components such as LiveData, ViewModel, and using a Room Database with Architecture Components in Android. 

Also, used viewBinding with latest Kotlin code techniques with targetSdk 32. 

 ![Android-Google Code Scanner - Example](https://raw.githubusercontent.com/myinnos/Note-Android-App/main/Screenshot.png)

***LiveData:*** Live Data is a data holder class that can be observed. It holds as well as caches the latest version of the data and notifies our observer whenever the data is being updated or changed. Live Data automatically manages all of this since it is aware of the relevant lifecycle status changes while observing.

***ViewModel:*** View Modal acts as a communication center between repository and UI. The UI no longer needs to worry about the origin of the data. The ViewModel instances survive Activity/Fragment recreation.

***Repository:*** Repository is a class that is mainly used to manage multiple sources of data.

***Entity:*** Entity is an annotated class that is used to describe a database table when we are working with Room.

***Room Database:*** Room Database is an improvised version of SQLite Database. It simplifies the database work and serves as an access point to the underlying SQLite database. The room uses DAO to issue queries to the SQLite database.

***DAO:*** DAO is a Data Access Object which is used for mapping SQL queries to functions.

##### Watch the code [here](https://github.com/myinnos/Note-Android-App/tree/main/app/src/main) and watch the [demo video here](https://media.geeksforgeeks.org/wp-content/uploads/20210722160210/20210722_155841.mp4)

##### Any Queries? or Feedback, please let me know by opening a [new issue](https://github.com/myinnos/Note-Android-App/issues/new)!

## Contact
#### Prabhakar Thota
* :globe_with_meridians: Website: [myinnos.in](http://www.myinnos.in "Prabhakar Thota")
* :email: e-mail: contact@myinnos.in
* :mag_right: LinkedIn: [PrabhakarThota](https://www.linkedin.com/in/prabhakarthota "Prabhakar Thota on LinkedIn")
* :thumbsup: Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on twitter")    
* :camera: Instagram: [@prabhakar_t_](https://www.instagram.com/prabhakar_t_/ "Prabhakar Thota on Instagram")   

> If you appreciate my work, consider buying me a cup of :coffee: to keep me recharged :metal: by [PayPal](https://www.paypal.me/fansfolio)

License
-------

    Copyright 2022 MyInnos

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
