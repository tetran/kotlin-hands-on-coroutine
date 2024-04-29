package tasks

import contributors.User

/*
 In the initial list each user is present several times, once for each
 repository he or she contributed to.
 Merge duplications: each user should be present only once in the resulting list
 with the total value of contributions for all the repositories.
 Users should be sorted in a descending order by their contributions.

 The corresponding test can be found in test/tasks/AggregationKtTest.kt.
 You can use 'Navigate | Test' menu action (note the shortcut) to navigate to the test.
*/
fun List<User>.aggregate(): List<User> =
    groupBy { it.login }
        .map { (login, group) -> User(login, group.sumOf { it.contributions })}
        .sortedByDescending { it.contributions }

// // My solution
//fun List<User>.aggregate(): List<User> {
//    val map: MutableMap<String, Int> = mutableMapOf()
//    for (user in this) {
//        map[user.login] = (map[user.login] ?: 0) + user.contributions
//    }
//    return map.entries.stream()
//        .map { (k, v) -> User(k, v) }
//        .sorted { u1, u2 -> u2.contributions - u1.contributions }
//        .toList()
//}
