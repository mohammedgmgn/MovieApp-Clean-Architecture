package io.github.erikcaffrey.arch_components_paging_library.data.room

object DATABASE {
    const val DATABASE_MOVIE = "movies.db"
    const val DATABASE_MOVIE_VERSION = 1
    const val TABLE_MOVIE = "movie"

    const val SELECT_MOVIE = "SELECT * FROM $TABLE_MOVIE ORDER BY popularity DESC, title ASC"

    const val PAGE_SIZE = 20
}
