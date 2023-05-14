[![](https://jitpack.io/v/sam38124/JzDragUtil.svg)](https://jitpack.io/#sam38124/JzDragUtil)
[![Platform](https://img.shields.io/badge/Platform-%20Android%20-brightgreen.svg)](https://github.com/sam38124)
[![characteristic](https://img.shields.io/badge/特點-%20輕量級%20%7C%20簡單易用%20%20%7C%20穩定%20-brightgreen.svg)](https://github.com/sam38124)
# JzDragUtil
This is a util can very easily to drag view and transposition~
## List
* [How to import to project?](#Import)
* [Quick Start](#Use)
* [About me](#About)

<a name="Import"></a>
## How to introduce to the project?
> Support jcenter。 <br/>

### jcenter
Add into build.gradle 
```kotlin
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add into dependencies
```kotlin
dependencies {
implementation 'com.github.sam38124:JzGragUtil:1.0'
}
```
<a name="Use"></a>
## Quick Start
```kotlin
//If ACTION_UP and both of view1 and view2 is overlapping they will transposition
//view1 can't drag out rootview
   DragUtil(view1, view2, rootview, 1000,
            object : callback {
                override fun isOverLapping(overlapping: Boolean) {
                  if(overlapping){
                      rootview.imageView.background=resources.getDrawable(R.mipmap.background1)
                  }else{
                      rootview.imageView.background=resources.getDrawable(R.mipmap.backgroung2)
                  }
                }
            })

```

<a name="About"></a>
# About me
#### <font color="#0000dd"> Work for: </font><br /> 
+ ##### <font color="#660000">【Orange Electronic】</font><br /> 
#### <font color="#0000dd"> Position: </font><br /> 
#### <font color="#0000dd"> Contact information: </font><br /> 
+  ##### line:sam38124<br /> 

+  ##### gmail:sam38124@gmail.com
