<template>
  <form class="new-book-form" v-on:submit.prevent="addBook">
    <div class="field">
      <label for="title">Title: </label>
      <input
        class="title-input"
        type="text"
        name="title"
        v-model="newBook.title"
      />
    </div>
    <div class="field">
      <label for="author">Auhtor: </label>
      <input
        class="author-input"
        type="text"
        name="author"
        v-model="newBook.author"
      />
    </div>
    <div class="field">
      <label for="isbn">ISBN: </label>
      <input
        class="isbn-input"
        type="text"
        name="isbn"
        v-model="newBook.isbn"
      />
    </div>
    <button type="submit">Submit</button>
  </form>
</template>

<script>
export default {
  name: "new-book-form",
  data() {
    return {
      newBook: {
        name: "",
        author: "",
         isbn: "",
        read: false
      }
    };
  },
  methods: {
    addBook() {
      this.newBook.read = true;
      this.$store.commit("ADD_BOOK", this.newBook);
      this.newBook = {
        title: "",
        author: "",
        isbn: "",
        read: false,
      };
    },
  },
};
</script>

<style>
</style>