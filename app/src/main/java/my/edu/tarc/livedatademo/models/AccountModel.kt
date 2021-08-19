package my.edu.tarc.livedatademo.models

import android.accounts.Account
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountModel(accNo:String, owner:String, balance:Double) :ViewModel(){
    var accNo : String = ""
    var owner : String = ""
    //var balance = MutableLiveData<Double>()
   // var balance: Double = 0.0
    //var balance : MutableLiveData<Double> = MutableLiveData<Double>()
    //LiveData is after update is unable to change anymore
    //MutableLiveData is after update is able to change again
    private var _balance = MutableLiveData<Double>()
    val balance : LiveData<Double>
                get()=_balance

    init {
        this.accNo = accNo
        this.owner = owner
        this._balance.value = balance
    }


    fun deposit(amount: Double) {
       _balance.value = (_balance.value)?.plus(amount)
    }

    fun withdraw(amount:Double){
        _balance.value = (_balance.value)?.minus(amount)
    }

}