package com.example.core_ui.view.bottom_app_bar

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.core_ui.CustomColor
import com.example.core_ui.FontStyle
import com.example.core_ui.view.bottom_app_bar.models.NavigationItem

@Composable
fun BottomAppBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Message,
        NavigationItem.Profile
    )
    BottomNavigation(backgroundColor = CustomColor.BarColor) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    if (currentRoute?.parent?.route != item.route) {
                        navController.navigate(item.route)
                    }
                },
                icon = {
                    BottomIcon(item = item)
                },
                label = {
                    Text(
                        text = stringResource(item.title),
                        color = if (currentRoute?.hierarchy?.any { it.route == item.route } == true
                        ) CustomColor.ActiveButtonColor else CustomColor.Grey,
                        style = FontStyle.regular_10
                    )
                },
                selectedContentColor = CustomColor.ActiveButtonColor,
                unselectedContentColor = CustomColor.Grey
            )
        }
    }
}


// Иконки нижнего меню с реализацией показа количества загруженных заданий при синхронизации
@Composable
private fun BottomIcon(
//    notViewedTaskCount: Int,
    item: NavigationItem,
//    newTaskCount: Int,
) {
    when (item) {
        //todo
//        NavigationItem.Message -> {
//            BadgedBox(
//                badge = {
//                    if (notViewedTaskCount > 0) {
//                        Column {
//                            Spacer(modifier = Modifier.height(2.dp))
//                            Badge(
//                                modifier = Modifier.size(18.dp),
//                                backgroundColor = Palette.Blue_notific,
//                                contentColor = Palette.White
//                            ) {
//                                Text(
//                                    text = if (notViewedTaskCount > Constants.notificationsVisible) {
//                                        stringResource(R.string.many_notifications)
//                                    } else {
//                                        "$notViewedTaskCount"
//                                    },
//                                    color = Palette.White,
//                                    fontSize = 8.sp,
//                                    style = Fonts.regular_10sp
//                                )
//                            }
//                        }
//                    }
//                }
//            ) {
//                Icon(
//                    painter = painterResource(item.icon),
//                    contentDescription = stringResource(item.title),
//                )
//            }
//        }

        else -> {
            Icon(
                painter = painterResource(item.icon),
                contentDescription = stringResource(item.title),
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}
