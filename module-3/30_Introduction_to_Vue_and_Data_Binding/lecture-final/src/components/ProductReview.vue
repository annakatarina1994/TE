<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
        <div class="well">
            <span class="amount"> {{ averageRating }}</span>
            Average Rating 
        </div>
        <div class="well">
            <span class="amount"> {{ numberOfOneStarReviews }}</span>
            1 Star Review{{ numberOfOneStarReviews === 1 ? '': 's' }} <!-- pluralize the word if there are more than one review -->
        </div>
        <div class="well">
            <span class="amount"> {{ numberOfTwoStarReviews }}</span>
            2 Star Review{{ numberOfTwoStarReviews === 1 ? '': 's' }} <!-- pluralize the word if there are more than one review -->
        </div>
        <div class="well">
            <span class="amount"> {{ numberOfThreeStarReviews }}</span>
            3 Star Review{{ numberOfThreeStarReviews === 1 ? '': 's' }} <!-- pluralize the word if there are more than one review -->
        </div>
        <div class="well">
            <span class="amount"> {{ numberOfFourStarReviews }}</span>
            4 Star Review{{ numberOfFourStarReviews === 1 ? '': 's' }} <!-- pluralize the word if there are more than one review -->
        </div>
        <div class="well">
            <span class="amount"> {{ numberOfFiveStarReviews }}</span>
            5 Star Review{{ numberOfFiveStarReviews === 1 ? '': 's' }} <!-- pluralize the word if there are more than one review -->
        </div>
    </div>

    <div class="review" v-for="review in reviews" v-bind:key="review.id">
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Parties for Squirrels",
      description:
        "Host and plan the perfect party for all of your squirrelly friends",
      reviews: [
        {
          reviewer: "Malcom Gladwell",
          title: "What a Book!",
          review: "It certainly was a book.  I mean, I can see that.",
          rating: 3,
        },
        {
          reviewer: "Tim Ferriss",
          title: "Had a cigar party started in less than 4 hours",
          review: "It should have been called the four hour cigar party.",
          rating: 4,
        },
      ],
    };
  },
  computed: {
      averageRating() {
          let sum = this.reviews.reduce(
              (currentSum, review) => {
                  return currentSum + review.rating;
              }, 0
          );
          return sum / this.reviews.length;
      },
      numberOfOneStarReviews() {
          return this.reviews.reduce(
          (currentCount, review) => {
              return currentCount + (review.rating === 1);
          }, 0
          );
      },
      numberOfTwoStarReviews() {
          return this.reviews.reduce(
          (currentCount, review) => {
              return currentCount + (review.rating === 2);
          }, 0
          );
      },
      numberOfThreeStarReviews() {
          return this.reviews.reduce(
          (currentCount, review) => {
              return currentCount + (review.rating === 3);
          }, 0
          );
      },
      numberOfFourStarReviews() {
          return this.reviews.reduce(
          (currentCount, review) => {
              return currentCount + (review.rating === 4);
          }, 0
          );
      },
      numberOfFiveStarReviews() {
          return this.reviews.reduce(
          (currentCount, review) => {
              return currentCount + (review.rating === 5);
          }, 0
          );
      },
  }
};
</script>

<style>
div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}
</style>