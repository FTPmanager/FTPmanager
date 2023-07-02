package com.example.ftpmanager.ui

import com.example.ftpmanager.R

object BottomNavItems {
    val bottom_nav_items = listOf(
        BottomNavItem(
            label = R.string.connect_menu,
            icon = R.drawable.ic_outline_file_download_24,
            route = Screens.CONNECT.name
        ),
        BottomNavItem(
            label = R.string.share_menu,
            icon = R.drawable.ic_outline_file_upload_24,
            route = Screens.SHARE.name
        ),
        BottomNavItem(
            label = R.string.sync_menu,
            icon = R.drawable.ic_outline_sync_24,
            route = Screens.SYNC.name
        ),
        BottomNavItem(
            label = R.string.file_status_menu,
            icon = R.drawable.ic_baseline_checklist_24,
            route = Screens.FILE_STATUS.name
        ),
        BottomNavItem(
            label = R.string.file_manager_menu,
            icon = R.drawable.ic_outline_folder_24,
            route = Screens.FILE_BROWSER.name
        )
    )
}