struct header_t{
  size_t size;
  unsigned is_free;
  struct header_t *next;
};

struct header_t *get_free_block(size_t size);
void *my_own_malloc(size_t size);
void my_own_malloc(void *block);
