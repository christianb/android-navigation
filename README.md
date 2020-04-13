# Navigation
This library helps you making android navigation more handy and better testable.

The `Navigationable` interface could be implemented by a `ViewModel`.
```
class MyViewModel: ViewModel(), Navigationable {
    override val navigator: Navigator = Navigator.create()

    fun navigateTo(navDirections: NavDirections) {
        navigator.to(navDirections)
    }
    
    fun navigateUp() {
        navigator.up()
    }
}
```

And could be observed from a Fragment:
```
class MyFragment : Fragment() {
    private val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
    
    override fun onCreateView(inflater: LayoutInflater, viewGroup: ViewGroup?, bundle: Bundle?): View? {
        setupNavigation(myViewModel)
    }   
}
```

That's it. No more configuration. The observation of the `Navigator` happens inside the `setupNavigation()` method.

## Contributors
* [Christian Bunk](https://github.com/christianb)
* [Ronaldo Pace](https://github.com/budius)