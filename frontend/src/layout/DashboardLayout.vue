<template>
  <div class="wrapper">
    <side-bar>
      <mobile-menu slot="content"></mobile-menu>
      <sidebar-link to="/room">
        <i class="nc-icon nc-controller-modern"></i>
        <p>Playing Game</p>
      </sidebar-link>
      <sidebar-link to="/user">
        <i class="nc-icon nc-circle-09"></i>
        <p>User Profile</p>
      </sidebar-link>
      <sidebar-link to="/ranking">
        <i class="nc-icon nc-chart-bar-32"></i>
        <p>Ranking</p>
      </sidebar-link>
      <sidebar-link to="/settings">
        <i class="nc-icon nc-settings-gear-64"></i>
        <p>Settings</p>
      </sidebar-link>
      <sidebar-link to="/notifications">
        <i class="nc-icon nc-bell-55"></i>
        <p>Notifications</p>
      </sidebar-link>

      

      <!-- 갖다쓰기용 나중에 지우기 -->
      <sidebar-link to="/icons">
        <i class="nc-icon nc-atom"></i>
        <p>Icons</p>
      </sidebar-link>

      <template slot="bottom-links" v-if="isLogin">
        <sidebar-link class="btn-danger"
                      to="/">
          <p @click="logout">Logout</p>
        </sidebar-link>
      </template>
    </side-bar>
    <div class="main-panel">
      <top-navbar></top-navbar>

      <dashboard-content @click="toggleSidebar">

      </dashboard-content>

      <content-footer></content-footer>
    </div>
  </div>
</template>
<style lang="scss">

</style>
<script>
  import TopNavbar from './TopNavbar.vue'
  import ContentFooter from './ContentFooter.vue'
  import DashboardContent from './Content.vue'
  // import MobileMenu from './MobileMenu.vue'
  export default {
    components: {
      TopNavbar,
      ContentFooter,
      DashboardContent,
      // MobileMenu
    },
    methods: {
      toggleSidebar () {
        if (this.$sidebar.showSidebar) {
          this.$sidebar.displaySidebar(false)
        }
      },

      logout() {
        localStorage.removeItem('nickname')
        localStorage.removeItem('JWT_TOKEN')
        alert('로그아웃 되었습니다!')
      }
    },

    data: function() {
      return {
        nickname: null
      }
    },

    computed: {
      isLogin() {
        if (localStorage.getItem('JWT_TOKEN')) {
          this.nickname = localStorage.getItem('nickname')
          return true
        } else {
          return false
        }
      }
    }
  }

</script>
