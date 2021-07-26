<template>
  <div class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-4">
          <user-card>
          </user-card>
        </div>
        <div class="col-md-8">
          <detail-profile v-if="detail"
          @change="change"
          >
          </detail-profile>
          <edit-profile-form v-if="update">
          </edit-profile-form>
        </div>
        
      </div>
      <div>game history</div>
      <div class="row">
        <game-history-card class="m-3"></game-history-card>
        <game-history-card class="m-3"></game-history-card>
        <game-history-card class="m-3"></game-history-card>
        <game-history-card class="m-3"></game-history-card>
      </div>
    </div>
  </div>
</template>
<script>
  import DetailProfile from './UserProfile/DetailProfile.vue'
  import EditProfileForm from './UserProfile/EditProfileForm.vue'
  import UserCard from './UserProfile/UserCard.vue'
  import GameHistoryCard from './UserProfile/GameHistoryCard.vue'

  export default {
    components: {
      DetailProfile,
      EditProfileForm,
      UserCard,
      GameHistoryCard
    },
    data () {
      return {
        detail: true,
        update: false,
      }
    },
    methods: {
      change () {
        this.detail = !this.detail
        this.update = !this.update
      }
    }
  }

</script>
<style>

</style>
