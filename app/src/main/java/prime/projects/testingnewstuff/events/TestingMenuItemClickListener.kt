package prime.projects.testingnewstuff.events

import prime.projects.testingnewstuff.data.MenuItem

interface TestingMenuItemClickListener {
    fun onItemClicked(menuItem: MenuItem)
}