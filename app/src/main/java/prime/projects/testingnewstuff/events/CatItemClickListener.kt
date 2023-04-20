package prime.projects.testingnewstuff.events

import prime.projects.testingnewstuff.data.TestingCoffeeMenuItem

interface CatItemClickListener {
    fun onItemClicked(testingCoffeeMenuItem: TestingCoffeeMenuItem)
}