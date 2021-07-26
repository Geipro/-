import DashboardLayout from '../layout/DashboardLayout.vue'
// GeneralViews
import NotFound from '../pages/NotFoundPage.vue'

// Admin pages
import Index from 'src/pages/Index.vue'
import Room from 'src/pages/Room.vue'
import UserProfile from 'src/pages/UserProfile.vue'
import Ranking from 'src/pages/Ranking.vue'
import Settings from 'src/pages/Settings.vue'
import Icons from 'src/pages/Icons.vue'
import Notifications from 'src/pages/Notifications.vue'
import Main from 'src/pages/Main.vue'

const routes = [
  { path: '/',
    component: Main,
  },


  {
    path: '/',
    component: DashboardLayout,
    redirect: '/index',
    children: [
      {
        path: 'index',
        name: 'Index',
        component: Index
      },
      {
        path: 'room',
        name: 'Room',
        component: Room
      },
      {
        path: 'user',
        name: 'User',
        component: UserProfile
      },
      {
        path: 'ranking',
        name: 'Ranking',
        component: Ranking
      },
      {
        path: 'settings',
        name: 'Settings',
        component: Settings
      },
      {
        path: 'notifications',
        name: 'Notifications',
        component: Notifications
      },
      {
        path: 'icons',
        name: 'Icons',
        component: Icons
      },
    ]
  },
  { path: '*', component: NotFound }
]

/**
 * Asynchronously load view (Webpack Lazy loading compatible)
 * The specified component must be inside the Views folder
 * @param  {string} name  the filename (basename) of the view to load.
function view(name) {
   var res= require('../components/Dashboard/Views/' + name + '.vue');
   return res;
};**/

export default routes
