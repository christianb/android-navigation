# Navigation
This library helps you making android navigation more handy and better testable.

The `Navigationable` interface could be implementend by a `ViewModel`.
```
class MyViewModel: ViewModel(), Navigationable {
    override val navigationLiveData = NavigationLiveData()

    fun navigateTo(navDirections: NavDirections) {
        navigationLiveData.to(navDirections)
    }
    
    fun navigateUp() {
        navigationLiveData.up()
    }
}
```

And could be observed from a Fragment:
```
class MyFragment : Fragment() {
    private val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
    
    override fun onCreateView(inflater: LayoutInflater, vG: ViewGroup?, b: Bundle?): View? {
        setupNavigation(myViewModel)
    }   
}
```

Thats it. No more configuration. The observation of the `NavigationLiveData` happens inside the `setupNavigation()` method.