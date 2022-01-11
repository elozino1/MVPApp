package com.example.mvpapp

// instantiating the objects of View and Model Interface
// creating object of View Interface
// creating object of Model Interface
class Presenter(
    private var mainView: MainActivityContract.View?,
    private val model: MainActivityContract.Model) : MainActivityContract.Presenter,
    MainActivityContract.Model.OnFinishedListener {

    // operations to be performed
    // on button click
    override fun onButtonClick() {
        if (mainView != null) {
            mainView!!.showProgress()
        }
        model.getNextCourse(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    // method to return the string
    // which will be displayed in the
    // Course Detail TextView
    override fun onFinished(string: String?) {
        if (mainView != null) {
            mainView!!.loadImage(string)
            mainView!!.hideProgress()
        }
    }

}

