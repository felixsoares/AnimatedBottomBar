###### This library allows you to show bottom navigation quickly, simply and animated.


# AnimatedBottomBar


![](https://img.shields.io/badge/SDK-19+-success.svg) ![](https://img.shields.io/badge/Android%20Arsenal-Animated%20Bottom%20Bar-orange.svg) ![](https://img.shields.io/badge/Version-1.0-blue.svg)

![](https://media.giphy.com/media/3Wv7KC3EK813AginQK/giphy.gif)

### Getting Started

Add it in your root build.gradle (Project module)

```gradle
allprojects {
   repositories {
        ...
        maven { url 'https://jitpack.io' }
   }
}
```

Add the dependency in build.gradle (App module)

```gradle
dependencies {
	implementation 'com.github.felixsoares:AnimatedBottomBar:1.0'
}
```
## Usage example

In layout file

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    <com.felixsoares.animatedbottombar.ui.BottomBar
            android:id="@+id/bottom"
            android:layout_width="match_parent"
            android:layout_height="56dp"
            app:layout_constraintBottom_toBottomOf="parent"/>

</android.support.constraint.ConstraintLayout>
```

In Activity or Fragment

```kotlin
bottom
            .addItem(Item("Home", R.drawable.ic_home))
            .addItem(Item("Search", R.drawable.ic_search))
            .addItem(Item("Profile", R.drawable.ic_person))
            .build()
```

### Documentation

1) Support click listener.

```kotlin
import com.felixsoares.animatedbottombar.NavigationListner

class MainActivity : AppCompatActivity(), NavigationListner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default)

        bottom
            .setupListner(this)
            .addItem(Item("Home", R.drawable.ic_home))
            .addItem(Item("Search", R.drawable.ic_search))
            .addItem(Item("Profile", R.drawable.ic_person))
            .build()
    }

    override fun OnClick(position: Int) {
        Log.i("OnClick", "position $position")
    }
}
```

2) Support multi color (layout).

```xml
<com.felixsoares.animatedbottombar.ui.BottomBar
            android:id="@+id/bottom"
            android:layout_width="match_parent"
            android:layout_height="56dp"
            app:text_size="14sp"
            app:bg_color="#ec4f16"
            app:bg_icon_color="#a43fcc20"
            app:tint_icon_color="#191793"
            app:text_color="@color/colorPrimary"
            app:indicator_color="@color/colorAccent"/>
```

2.1) Support multi color (code).

```kotlin
bottom
            .setBgColor(android.R.color.black)
            .setBgIconColor(android.R.color.holo_blue_dark)
            .setIconColor(android.R.color.holo_green_dark)
            .setIndicatorColor(android.R.color.holo_red_dark)
            .setTextColor(android.R.color.holo_orange_dark)
            .setTextSize(12f)
            .addItem(Item("Home", R.drawable.ic_home))
            .addItem(Item("Search", R.drawable.ic_search))
            .addItem(Item("Profile", R.drawable.ic_person))
            .build()
```

3) Add item by item.

```kotlin
bottom.addItem(Item("Home", R.drawable.ic_home))
```

3.1) Add list of Itens.

```kotlin
val list = mutableListOf<Item>()
list.add(Item("Home", R.drawable.ic_home))
list.add(Item("Search", R.drawable.ic_search))
list.add(Item("Profile", R.drawable.ic_person))

bottom
		.setupItens(list)
		.build()
```

4) Support itens with text or icons.

```kotlin
bottom
		.addItem(Item("Home", R.drawable.ic_home))
		.addItem(Item("Search", R.drawable.ic_search))
		.addItem(Item(R.drawable.ic_notifications_gray, R.drawable.ic_notifications))
```

MIT License

Copyright (c) 2019 Felix Soares

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
