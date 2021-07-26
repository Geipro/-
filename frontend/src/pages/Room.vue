<template>
  <div class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-3 overflow-auto" style="height:400px">
          <user-list>
          </user-list>
        </div>
        <div class="col-md-9 overflow-auto" style="height:400px">
          <room-info>
          </room-info>
        </div>
      </div>
      <div class="row">
        <div class="col-md-3">
          <user-info>
          </user-info>
        </div>
        <div class="col-md-9">
          <chat>
          </chat>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import RoomInfo from './UserProfile/RoomInfo.vue'
  import Chat from './UserProfile/Chat.vue'
  import UserList from './UserProfile/UserList.vue'
  import UserInfo from './UserProfile/UserInfo.vue'

  export default {
    components: {
      RoomInfo,
      UserList,
      UserInfo,
      Chat
    }
  }

</script>
<style>

</style>
