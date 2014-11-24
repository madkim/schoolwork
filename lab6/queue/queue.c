// Matthew Kim
// madkim
// cmps12b
// 11/24/14
// queue.c
// Creates a simple queue in C

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "queue.h"

#define STUBPRINTF(...) fprintf(stderr, __VA_ARGS__);

/* Internal implementation definitions */
struct queue_node {
   queue_item_t item;
   struct queue_node *link;
};

typedef struct queue_node queue_node;

struct queue {
   queue_node *front;
   queue_node *rear;
};

/* Functions */

queue *queue_new(void) {
   struct queue *this = malloc(sizeof (queue));
   this-> front = this-> rear = NULL;
   return this;

}

void queue_free(queue *this) {
   assert(queue_isempty(this));
   free(this);
}

void queue_insert(queue *this, queue_item_t item) {

   if(item != NULL && !queue_isempty(this)){
      struct queue_node *newNode = malloc(sizeof (queue_node));
      newNode->item = item;
      newNode->link = NULL;
      this->rear->link = newNode;
      this->rear = newNode;
   } 
   else if(item != NULL && queue_isempty(this)){
      struct queue_node *newNode = malloc(sizeof (queue_node));
      newNode->item = item;
      newNode->link = NULL;
      this->front = newNode;
      this->rear = newNode;
   }
}

queue_item_t queue_remove(queue *this) {
   if(queue_isempty(this))
      return NULL;

   else{
      queue_node *temp = this->front;
      queue_item_t remvItem = temp->item;
      this->front = this->front->link;
      free(temp);
      return remvItem;
   }
}

bool queue_isempty(queue *this) {
   return this->front == NULL;
}
