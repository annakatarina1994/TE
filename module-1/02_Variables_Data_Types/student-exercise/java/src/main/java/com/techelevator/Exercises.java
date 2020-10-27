package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		
		int numberOfRaccoons = 3;
		int raccoonsThatWentHome = 2;
		int raccoonsLeft = numberOfRaccoons - raccoonsThatWentHome;
		System.out.println(raccoonsLeft);

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int flowersMinusBees = numberOfFlowers - numberOfBees;
		System.out.println(flowersMinusBees);

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		
		int initialNumOfPigeons = 1;
		int newPigeons = 1;
		int pigeonsEatingBreadcrumbs = initialNumOfPigeons + newPigeons;
		System.out.println(pigeonsEatingBreadcrumbs);

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		
		int initialOwls = 3;
		int newOwls = 2;
		int owlsOnFence = initialOwls + newOwls;
		System.out.println(owlsOnFence);

        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		
		int beaversWorking = 2;
		int beaversSwimming = 1;
		int beaversStillWorking = beaversWorking - beaversSwimming;
		System.out.println(beaversStillWorking);

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int initialToucans = 2;
		int newToucans = 1;
		int toucansOnTreeLimb = initialToucans + newToucans;
		System.out.println(toucansOnTreeLimb);
		
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		
		int squirrels = 4;
		int nuts = 2;
		int nutsVersusSquirrels = squirrels - nuts;
		System.out.println(nutsVersusSquirrels);

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */

		double quarter = 0.25;
		double dime = 0.10;
		double twoNickels = 0.10;
		double moneyHiltFound = quarter + dime + twoNickels;
		System.out.printf("%.2f\n",moneyHiltFound);

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		
		int brierMuffins = 18;
		int macAdamsMuffins = 20;
		int flanneryMuffins = 17;
		int totalMuffins = brierMuffins + macAdamsMuffins + flanneryMuffins;
		System.out.println(totalMuffins);

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		
		double vovoPrice = 0.24;
		double whistlePrice = 0.14;
		double totalPrice = vovoPrice + whistlePrice;
		System.out.printf("%.2f\n", totalPrice);

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		
		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallows = largeMarshmallows + miniMarshmallows;
		System.out.println(totalMarshmallows);

        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		
		int hiltHouseSnow = 29;
		int brecknockSnow = 17;
		int snowDifference = hiltHouseSnow - brecknockSnow;
		System.out.println(snowDifference);

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		
		int hiltsTotalMoney = 10;
		int toyTruckCost = 3;
		int pencilCaseCost = 2;
		int moneyLeftOver = hiltsTotalMoney - toyTruckCost - pencilCaseCost;
		System.out.println(moneyLeftOver);

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		
		int initialMarbles = 16;
		int lostMarbles = 7;
		int totalMarbles = initialMarbles - lostMarbles;
		System.out.println(totalMarbles);

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		
		int megansSeashells = 19;
		int totalSeashellsDesired = 25;
		int seashellsNeeded = totalSeashellsDesired - megansSeashells;
		System.out.println(seashellsNeeded);

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		
		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;
		System.out.println(greenBalloons);

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		
		int booksOnShelf = 38;
		int newBooksAdded = 10;
		int totalBooks = booksOnShelf + newBooksAdded;
		System.out.println(totalBooks);

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		
		int beeLegs = 6;
		int bees = 8;
		int totalBeeLegs = beeLegs * bees;
		System.out.println(totalBeeLegs);

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		
		double iceCreamConeCost = 0.99;
		double iceCreamConeCostTotal = iceCreamConeCost * 2;
		System.out.println(iceCreamConeCostTotal);

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		
		int hiltsCurrentRocks = 64;
		int totalRocks = 125;
		int rocksNeeded = totalRocks - hiltsCurrentRocks;
		System.out.println(rocksNeeded);
		

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		
		int marblesHad = 38;
		int marblesLost = 15;
		int marblesLeft = marblesHad - marblesLost;
		System.out.println(marblesLeft);

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		
		int milesToConcert = 78;
		int milesDriven = 32;
		int milesLeft = milesToConcert - milesDriven;
		System.out.println(milesLeft);

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		
		int morningMinutes = 90;
		int afternoonMinutes = 45;
		int totalShovelingTime = morningMinutes + afternoonMinutes;
		System.out.println(totalShovelingTime);

        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		
		double hotDogsBought = 6;
		double hotDogCost = 0.50;
		double totalHotDogCost = hotDogsBought * hotDogCost;
		System.out.printf("%.2f\n", totalHotDogCost);

        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		
		double hiltsCents = 0.50;
		double pencilCost = 0.07;
		double pencilsHiltCanBuy = hiltsCents / pencilCost;
		System.out.println(Math.floor(pencilsHiltCanBuy));

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		
		int totalButterflies = 33;
		int orangeButterflies = 20;
		int redButterflies = totalButterflies - orangeButterflies;
		System.out.println(redButterflies);

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		
		double katesPayment = 1.00;
		double candyCost = 0.54;
		double katesChange = katesPayment - candyCost;
		System.out.printf("%.2f\n", katesChange);

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		
		int currentTrees = 13;
		int newTrees = 12;
		int totalTrees = currentTrees + newTrees;
		System.out.println(totalTrees);

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		
		int daysToSeeGrandma = 2;
		int hoursInADay = 24;
		int hoursToSeeGrandma = daysToSeeGrandma * hoursInADay;
		System.out.println(hoursToSeeGrandma);

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		
		int numOfCousins = 4;
		int piecesOfGum = 5;
		int gumNeeded = numOfCousins * piecesOfGum;
		System.out.println(gumNeeded);

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		
		double moneyDanHas = 3.00;
		double candyBarCost = 1.00;
		double moneyDanHasLeft = moneyDanHas - candyBarCost;
		System.out.println(moneyDanHasLeft);

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		
		int boats = 5;
		int peopleOnBoat = 3;
		int totalPeopleOnBoats = peopleOnBoat * boats;
		System.out.println(totalPeopleOnBoats);

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int ellensLegos = 380;
		int legosLost = 57;
		int legosLeft = ellensLegos - legosLost;
		System.out.println(legosLeft);
		
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		
		int muffinsBaked = 35;
		int muffinsWanted = 83;
		int muffinsArthurNeedsToBake = muffinsWanted - muffinsBaked;
		System.out.println(muffinsArthurNeedsToBake);

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		
		int willysCrayons = 1400;
		int lucysCrayons = 290;
		int crayonDifference = willysCrayons - lucysCrayons;
		System.out.println(crayonDifference);

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		
		int stickersPerPage = 10;
		int pagesOfStickers = 22;
		int totalStickers = stickersPerPage * pagesOfStickers;
		System.out.println(totalStickers);

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		
		int cupcakes = 96;
		int children = 8;
		int cupcakesPerChild = cupcakes / children;
		System.out.println(cupcakesPerChild);

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		
		int gingerbreadCookies = 47;
		int cookiesPerJar = 6;
		int leftOverCookies = gingerbreadCookies % cookiesPerJar;
		System.out.println(leftOverCookies);

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		
		int croissants = 59;
		int neighbors = 8;
		int leftOverCroissants = croissants % neighbors;
		System.out.println(leftOverCroissants);

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		
		int cookiesPerTray = 12;
		int cookiesToPrepare = 276;
		int traysNeeded = cookiesToPrepare / cookiesPerTray;
		System.out.println(traysNeeded);

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		
		int totalPretzels = 480;
		int oneServing = 12;
		int numberOfServings = totalPretzels / oneServing;
		System.out.println(numberOfServings);

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		
		int totalLemonCupcakes = 53;
		int cupcakesLeftHome = 2;
		int cupcakesPerBox = 3;
		int cupcakesForOrphanage = totalLemonCupcakes - cupcakesLeftHome;
		int boxesGivenAway = cupcakesForOrphanage / cupcakesPerBox;
		System.out.println(boxesGivenAway);

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		
		int carrotSticks = 74;
		int people = 12;
		int carrotsUneaten = carrotSticks % people;
		System.out.println(carrotsUneaten);

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		
		int teddyBears = 98;
		int bearsPerShelf = 7;
		int shelvesFilledWithBears = teddyBears / bearsPerShelf;
		System.out.println(shelvesFilledWithBears);

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		
		int picsPerAlbum = 20;
		int pictures = 480;
		int albumsNeeded = pictures / picsPerAlbum;
		System.out.println(albumsNeeded);

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		
		int tradingCards = 94;
		int cardsPerBox = 8;
		int boxesFilled = tradingCards / cardsPerBox;
		int leftOverCards = tradingCards % cardsPerBox;
		System.out.println(boxesFilled + " and " + leftOverCards);

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		
		int books = 210;
		int repairedShelves = 10;
		int booksPerShelf = books / repairedShelves;
		System.out.println(booksPerShelf);

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		
		double cristinasCroissants = 17;
		double guests = 7;
		double croissantsPerGuest = cristinasCroissants / guests;
		System.out.printf("%.2f\n", croissantsPerGuest);

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		
		double billsAverage = (12 * 14) / 2.15;
		double jillsAverage = (12 * 14) / 1.90;
		double combinedHourlyRate = billsAverage + jillsAverage;
		double projectRoomsArea = 5 * (12 * 14);
		double hoursToPaintRooms = projectRoomsArea / combinedHourlyRate;
		System.out.printf("%.2f\n", hoursToPaintRooms);
		
		double totalAreaOf623Rooms = 623 * (12 * 14);
		double totalHoursToPaint = totalAreaOf623Rooms / combinedHourlyRate;
		double daysToPaint623Rooms = totalHoursToPaint / 8;
		System.out.printf("%.2f\n", daysToPaint623Rooms);

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		
		String firstName = "Anna";
		String lastName = "Lizon";
		String middleInitial = "K.";
		String fullName = lastName + ", " + firstName + " " + middleInitial;
		System.out.println(fullName);

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		
		double totalDistance = 800;
		double traveledDistance = 537;
		double fractionCompleted = traveledDistance / totalDistance;
		int percentCompleted = (int) (fractionCompleted * 100);
		System.out.println(percentCompleted + "%");


	}

}
