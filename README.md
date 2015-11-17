# StateView
    multi stateView for android
* it contains five state:
    * Content
    * Loading
    * Empty
    * Error
    * Content_Loading
    
![screenshot](https://github.com/hqucsx/StateView/blob/master/art/content.png)
![screenshot](https://github.com/hqucsx/StateView/blob/master/art/loading.png)
![screenshot](https://github.com/hqucsx/StateView/blob/master/art/error.png)
![screenshot](https://github.com/hqucsx/StateView/blob/master/art/empty.png)
![screenshot](https://github.com/hqucsx/StateView/blob/master/art/content_loading.png)

## Using StateView

```xml
<com.hqucsx.library.StateView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/mStateView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:state_current="content"
    app:state_empty="@layout/empty_view"
    app:state_error="@layout/error_view"
    app:state_loading="@layout/loading_view">

    <ListView
        android:id="@+id/listview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:listitem="@android:layout/simple_list_item_1" />
</com.hqucsx.library.StateView>
```
you can get currentState by
```java
    public View getCurrentState()
```
set currentState by
```java
    public void setCurrentState(@ViewState int state) 
```
get current stateView by
```java
    public View getStateView(@ViewState int state) 
```
set stateView 
```java
    public void setViewForState(View stateView, @ViewState int state, boolean switchToState)
````



Attributes

```xml
        <attr name="state_error" format="reference"/>
        <attr name="state_empty" format="reference"/>
        <attr name="state_loading" format="reference"/>
        <attr name="state_current" format="enum">
            <enum name="content" value="0"/>
            <enum name="loading" value="1"/>
            <enum name="error" value="2"/>
            <enum name="empty" value="3"/>
            <enum name="content_loading" value="4"/>
```