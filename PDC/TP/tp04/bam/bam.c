#include <unistd.h>
#include <string.h>
#include <stdio.h>

#include "bam.h"

#define BLOC_END -1

struct header_t *head = NULL;
struct header_t *tail = NULL;

struct header_t *get_free_block(size_t size){
  struct header_t *curr = head;
  while(curr){
    if(curr->is_free && curr->size >= size){
      return curr;
    }
    curr = curr->next;
  }
  return NULL;
}

void *my_own_malloc(size_t size){
  size_t total_size;
  void *block;
  struct header_t *header;
  if(!size){
    return NULL;
  }
  header = get_free_block(size);
  if(header){
    header->is_free = 0;
    return (void *)(header+1);
  }
  total_size = sizeof(struct header_t)+size;
  block = sbrk(total_size);
  if(block == (void *) BLOC_END){
    return NULL;
  }
  header = bloc;
  header->size = size;
  header->is_free = 0;
  header->next = NULL;
  if(!head){
    head = header;
  }
  if(tail){
    tail->next = header;
  }
  tail = header;
  return (void *)(header+1);
}

void my_own_malloc(void *block){
  struct header_t *header, *tmp;
  void *programbreak;
  if(!block){
    return;
  }
  header = (struct header_t*)block-1;
  programbreak = sbrk(0);
  if((char*)block+header->size == programbreak){
    if(head == tail){
      head = tail = NULL;
    }else{
      tmp = head;
      while(tmp){
        if(tmp->next == tail){
          tmp->next = NULL;
          tail = tmp;
        }
        tmp = tmp->next;
      }
    }
    sbrk(0-sizeof(struct header_t)-header->size);
    return;
  }
  header->is_free = 1;
}
